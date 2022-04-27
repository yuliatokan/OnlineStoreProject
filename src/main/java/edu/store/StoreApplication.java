package edu.store;

import edu.store.entity.Product;
import edu.store.entity.UserRole;
import edu.store.service.impl.DefaultProductService;
import edu.store.service.impl.DefaultProductSizeService;
import edu.store.service.impl.DefaultProductTypeService;
import edu.store.service.impl.DefaultUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }

    @Bean
    public CommandLineRunner addAdmin(final DefaultUserService userService) {
        return strings -> {
            userService.addUser("admin@gmail.com", "8cb2237d0679ca88db6464eac60da96345513964", "Admin", "123", UserRole.ADMIN); //12345
        };
    }

    @Bean
    public CommandLineRunner addProductSize(final DefaultProductSizeService productSizeService) {
        return strings -> {
            productSizeService.addProductSize("XS");
            productSizeService.addProductSize("S");
            productSizeService.addProductSize("M");
            productSizeService.addProductSize("L");
            productSizeService.addProductSize("XL");
            productSizeService.addProductSize("NO SIZE");
        };
    }

    @Bean
    public CommandLineRunner addProductType(final DefaultProductTypeService productTypeService) {
        return strings -> {
            productTypeService.addProductType("Dresses");
            productTypeService.addProductType("Overalls");
            productTypeService.addProductType("T-shirts&Tops");
            productTypeService.addProductType("Denim");
            productTypeService.addProductType("Skirts");
            productTypeService.addProductType("Pants");
            productTypeService.addProductType("Pullovers");
            productTypeService.addProductType("Sweatshirts");
            productTypeService.addProductType("Coats");
        };
    }

    @Bean
    public CommandLineRunner addProduct(final DefaultProductService productService, final DefaultProductTypeService productTypeService, final DefaultProductSizeService productSizeService) {
        return strings -> {
            List<Long> sizes = new ArrayList<>();
            sizes.add(2L);
            sizes.add(3L);
            sizes.add(4L);
            sizes.add(5L);
            sizes.add(6L);
            productService.addProduct(new Product("Blue Dress", 100, "Beautiful blue dress",
                    photoToByte("static/img/products/prod1_1.jpg", "static/img/products/prod1_2.jpg", "static/img/products/prod1_3.jpg"),
                    productTypeService.findProductTypeById(8L),
                    productSizeService.findProductSizesByIds(sizes)));

            productService.addProduct(new Product("Purple Overall", 110, "Beautiful purple overall",
                    photoToByte("static/img/products/prod2_1.jpg", "static/img/products/prod2_2.jpg", "static/img/products/prod2_3.jpg"),
                    productTypeService.findProductTypeById(9L),
                    productSizeService.findProductSizesByIds(sizes)));

            productService.addProduct(new Product("Blue Top", 60, "Beautiful blue top",
                    photoToByte("static/img/products/prod3_1.jpg", "static/img/products/prod3_2.jpg", "static/img/products/prod3_3.jpg"),
                    productTypeService.findProductTypeById(10L),
                    productSizeService.findProductSizesByIds(sizes)));

            productService.addProduct(new Product("Floral Skirt", 80, "Beautiful flowers skirt",
                    photoToByte("static/img/products/prod4_1.jpg", "static/img/products/prod4_2.jpg", "static/img/products/prod4_3.jpg"),
                    productTypeService.findProductTypeById(12L),
                    productSizeService.findProductSizesByIds(sizes)));

            productService.addProduct(new Product("Blue Pants", 90, "Beautiful blue pants",
                    photoToByte("static/img/products/prod5_1.jpg", "static/img/products/prod5_2.jpg", "static/img/products/prod5_3.jpg"),
                    productTypeService.findProductTypeById(13L),
                    productSizeService.findProductSizesByIds(sizes)));

            productService.addProduct(new Product("Grey Sweatshirt", 90, "Beautiful grey sweatshirt",
                    photoToByte("static/img/products/prod6_1.jpg", "static/img/products/prod6_2.jpg", "static/img/products/prod6_3.jpg"),
                    productTypeService.findProductTypeById(14L),
                    productSizeService.findProductSizesByIds(sizes)));

            productService.addProduct(new Product("Blue coat", 90, "Beautiful blue coat",
                    photoToByte("static/img/products/prod7_1.jpg", "static/img/products/prod7_2.jpg", "static/img/products/prod7_3.jpg"),
                    productTypeService.findProductTypeById(16L),
                    productSizeService.findProductSizesByIds(sizes)));
        };
    }

    private byte[][] photoToByte(String path1, String path2, String path3) throws IOException {
        byte[][] photos = new byte[3][0];

        photos[0] = StreamUtils.copyToByteArray(new ClassPathResource(path1).getInputStream());
        photos[1] = StreamUtils.copyToByteArray(new ClassPathResource(path2).getInputStream());
        photos[2] = StreamUtils.copyToByteArray(new ClassPathResource(path3).getInputStream());

        return photos;
    }
}

class Listener extends Thread {

    private final Connection conn;
    private final org.postgresql.PGConnection pgconn;

    Listener(Connection conn) throws SQLException {
        this.conn = conn;
        this.pgconn = (org.postgresql.PGConnection) conn;
        Statement stmt = conn.createStatement();
        stmt.execute("LISTEN to_do_list");
        stmt.close();
    }

    public void run() {
        while (true) {
            try {
                // issue a dummy query to contact the backend
                // and receive any pending notifications.
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT 1");
                rs.close();
                stmt.close();

                org.postgresql.PGNotification notifications[] = pgconn.getNotifications();
                if (notifications != null) {
                    for (org.postgresql.PGNotification notification : notifications) {
                        System.out.println("Got notification: " + notification.toString());
                    }
                }

                // wait a while before checking again for new
                // notifications
                Thread.sleep(500);
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

}

class Notifier extends Thread {

    private final Connection conn;

    public Notifier(Connection conn) {
        this.conn = conn;
    }

    public void run() {
        while (true) {
            try {
                Statement stmt = conn.createStatement();
                stmt.execute("NOTIFY to_do_list");
                stmt.close();
                Thread.sleep(2000);
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

}
