package com.example.springbootlearn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by Ewen on 2017/12/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {
    @Test
    public void testHello() {
        String content = this.restTemplate.getForObject("/hi", String.class );
        assertThat(content).isEqualTo("ewen");
    }
    @Test
    public void testHello1() {
        String content = this.restTemplate.getForObject("/hello", String.class );
        assertThat(content).isEqualTo("ewen");
    }
	@Test
	public void testHello2() {
		int result = engine.add(10, 20);
		assertThat(result).isEqualTo(30);
        int ret1 = engine.get();
        assertThat(ret1).isEqualTo(0);
        int ret2 = engine2.get();
        System.out.print("ret1:" + ret1);
        System.out.print("ret2:" + ret2);
        assertThat(ret2).isEqualTo(0);
	}

    @Autowired
    private TestRestTemplate restTemplate;
	@Autowired
	private  EngineService engine;
    @Autowired
    private EngineService2 engine2;
}
