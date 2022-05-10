import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean1 =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean1.getMessage());

        HelloWorld bean2 =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean2.getMessage());

        System.out.println("bean1 == bean2? " + (bean1 == bean2));
        System.out.println(bean1);
        System.out.println(bean2);

        Cat cat1 = applicationContext.getBean("catBean", Cat.class);
        Cat cat2 = applicationContext.getBean("catBean", Cat.class);

        System.out.println("cat1 == cat2? " + (cat1 == cat2));
        System.out.println(cat1);
        System.out.println(cat2);

        ((AnnotationConfigApplicationContext)applicationContext).close();

    }
}