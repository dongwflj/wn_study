package com.hry.spring.grpc.mystream.custom;

import com.hry.spring.grpc.mystream.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public class HelloStreamServer {
	private static final Logger logger = LoggerFactory.getLogger(HelloStreamServer.class);

	private final int port;
	private final Server server;

	public HelloStreamServer(int port) throws IOException {
		this.port = port;
		this.server = ServerBuilder.forPort(port).addService(new HelloStreamService(HelloUtil.parseFeatures())).build();
	}

	// 启动服务
	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** shutting down gRPC server since JVM is shutting down");
				HelloStreamServer.this.stop();
				System.err.println("*** server shut down");
			}
		});
	}

	// 启动服务
	public void stop() {
		if (server != null) {
			server.shutdown();
		}
	}

	/**
	 * Await termination on the main thread since the grpc library uses daemon
	 * threads.
	 */
	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}

	public static void main(String[] args) throws Exception {
		//java.util.logging.Logger.getGlobal().setLevel(java.util.logging.Level.OFF);
//		Logger.getLogger("io.grpc").setLevel(Level.INFO);
//		Logger.class.
		HelloStreamServer server = new HelloStreamServer(8980);
		server.start();
		server.blockUntilShutdown();
	}

	/**
	 * 服务端类的实现
	 *
	 */
	private static class HelloStreamService extends HelloStreamGrpc.HelloStreamImplBase {
		private final List<SimpleFeature> features;

		public HelloStreamService(List<SimpleFeature> features) {
			this.features = features;
		}

		@Override
		public void simpleRpc(Simple request, StreamObserver<SimpleFeature> responseObserver) {
			logger.info(">>> simpleRpc() request:{}", request);
			SimpleFeature rtn = SimpleFeature.newBuilder().setName(request.getName() + "fromServer").setLocation(request)
					.build();
			responseObserver.onNext(rtn);
			responseObserver.onCompleted();
			logger.info("<<< simpleRpc() response：{}", rtn);
		}

		@Override
		public void server2ClientRpc(SimpleList request, StreamObserver<SimpleFeature> responseObserver) {
			logger.info(">>> server2ClientRpc():{}", request);
			for (SimpleFeature feature : this.features) {
				logger.info("server2ClientRpc() feature: {}", feature);
				Simple simpleLocation = feature.getLocation();
				for (Simple o : request.getSimpleListList()) {
					if (o.getNum() == simpleLocation.getNum()) {
						// 推送记录
						responseObserver.onNext(feature);
						logger.info("server2ClientRpc() send feature: {}", feature);
					}
				}
			}
			responseObserver.onCompleted();
			logger.info("<<< server2ClientRpc()");
		}

		/**
		 * 接收完所有的请求后，才返回一个对象
		 */
		@Override
		public StreamObserver<Simple> client2ServerRpc(final StreamObserver<SimpleSummary> responseObserver) {
			
			return new StreamObserver<Simple>() {
				int feature_count = 0;

				@Override
				public void onNext(Simple value) {
					// 接收请求
					logger.info(">>> client2ServerRpc client stream onNext()：num={}, content={} ", feature_count, value);
					feature_count++;
					try {
						for (int i = 0; i < 1; i++) {
							logger.info("Sleep 500ms");
							Thread.sleep(5);
						}
					}catch (InterruptedException e) {
						logger.info("client2ServerRpc client stream exception");
					}
					logger.info("<<< client2ServerRpc");

				}

				@Override
				public void onError(Throwable t) {
					logger.error("client2ServerRpc client stream error cancelled, e={}", t);
				}

				@Override
				public void onCompleted() {
					logger.info("client2ServerRpc client stream onCompleted");
					// 接收所有请求后，返回总数
					SimpleSummary summary = SimpleSummary.newBuilder().setFeatureCount(feature_count).build();
					responseObserver.onNext(summary);
					logger.info("client2ServerRpc client stream onCompleted SimpleSummary:{}", summary);
					// 结束请求
					responseObserver.onCompleted();
				}
			};
		}

		/**
		 * 每接收一个请求，立即返回一个对象
		 */
		@Override
		public StreamObserver<Simple> bindirectionalStreamRpc(final StreamObserver<Simple> responseObserver) {
			return new StreamObserver<Simple>() {
				@Override
				public void onNext(Simple value) {
					logger.info(">>> bindirectionalStreamRpc client stream onNext()：content={} ", value);
					for (SimpleFeature feature : features) {
						Simple simpleLocation = feature.getLocation();
						if (value.getNum() == simpleLocation.getNum()) {
							// 接收请求后，马上推送记录
							Simple rtn = Simple.newBuilder().setName(feature.getName() + "rtn")
									.setNum(feature.getLocation().getNum()).build();
							responseObserver.onNext(rtn);
						}
					}
					logger.info("<<< bindirectionalStreamRpc");

				}

				@Override
				public void onError(Throwable t) {
					logger.error("bindirectionalStreamRpc client stream error cancelled, e={}", t);
				}

				@Override
				public void onCompleted() {
					logger.info(">>> bindirectionalStreamRpc client stream onCompleted()");
					responseObserver.onCompleted();
					logger.info("<<< bindirectionalStreamRpc onCompleted()");
				}
			};
		}
	}
}
