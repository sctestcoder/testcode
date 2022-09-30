package netty;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Controller;

@Controller
public class NettyController {

    @PostConstruct
    private void start() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    new NettySocketServer(5010).run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }

    @PreDestroy
    private void destory() {

    }
}