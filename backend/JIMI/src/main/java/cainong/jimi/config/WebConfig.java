package cainong.jimi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置视频资源
        registry.addResourceHandler("/videos/**")
                .addResourceLocations("file:D:/nWork/videos/");

        // 配置图片资源
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:D:/nWork/images/");

        // 配置头像资源
        registry.addResourceHandler("/avators/**")
                .addResourceLocations("file:D:/nWork/avators/");
    }
}


