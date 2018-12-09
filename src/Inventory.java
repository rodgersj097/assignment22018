import javafx.scene.image.Image;
import java.util.*;

public class Inventory {

    private static TreeMap<String, LinkedList<Product>> inventoryMap = new TreeMap<>();


    public static void loadProducts() {

        //List of laptops
        Product lap1 = new Product("Acer", "Aspire", "15.6 inch | 32GB | i5-4300", 699.99, 2018, 5, new Image("Images\\AcerAspire13.jpg"));
        Product lap2 = new Product("Lenovo", "IdeaPad", "15.6 inch | 32GB | i5-2100t", 499.99, 2017, 8, new Image("Images\\LenovoThinkpad.jpg"));
        Product lap3 = new Product("HP", "Laptop", "14 inch | 16GB | i3-3400", 349.99, 2018, 3, new Image("Images\\hpLaptop.jpg"));
        Product lap4 = new Product("Acer", "CB3", "15.6 inch | 32GB | i3", 279.99, 2017, 20, new Image("Images\\AcerCB3.jpg"));
        Product lap5 = new Product("ASUS", "Laptop", "14 inch | 250GB | i3", 399.99, 2018, 24, new Image("Images\\asusLaptop.jpg"));
        //list of phones
        Product phone1 = new Product("Samsung", "Galaxy S8+", "64GB", 1120.00, 2018, 45, new Image("Images\\samsungS8.jpg"));
        Product phone2 = new Product("Samsung", "Galaxy Note 9", "13inch", 1017.99, 2018, 12, new Image("Images\\SamsungNote9.jpg"));
        Product phone3 = new Product("Apple", "Iphone X", "64GB", 1099.99, 2018, 48, new Image("Images\\appleX.jpg"));
        Product phone4 = new Product("ASUS", "ZenFone", "32GB", 299.99, 2017, 24, new Image("Images\\asusZenfone.jpg"));
        //Desktops
        Product Desk1 = new Product("Acer", "Nitro", "i5 | 1TB | GTX 1060", 999.99, 2018, 34, new Image("Images\\acerNitro.jpg"));
        Product Desk2 = new Product("AlienWare", "Aurora", "i7 | 1TB | Geforce 1080 ", 1999.99, 2018, 17, new Image("Images\\alienWareAurora.jpg"));
        Product Desk3 = new Product("Acer", "Predator", "i7", 1999.99, 2018, 2, new Image("Images\\acerPredator.jpg"));
        Product Desk4 = new Product("Dell", "Gaming PC", "i7", 2299.99, 2018, 4, new Image("Images\\dellGaming.jpg"));
        Product Desk5 = new Product("iBUYPOWER", "BB953", "i7", 2899.99, 2018, 6, new Image("Images\\iBuyPowerBB.jpg"));
        //Allin one
        Product aio1 = new Product("Asus", "Vivo", "i5 | ", 1199.99, 2018, 2, new Image("Images\\asusVivo.jpg"));
        Product aio2 = new Product("Dell", "Optiplex", "i5-8400t | 16gb Optane | 1TB HDD ", 329.99, 2018, 6, new Image("Images\\dellOptiplex.jpeg"));
        Product aio3 = new Product("Asus", "Vivo", "i5 |", 1199.99, 2018, 5, new Image("Images\\hpPavillonaio.jpg"));
        Product aio4 = new Product("Asus", "Vivo", "i7-7820H | 1TB SSD | 16GB Ram", 4599.99, 2018, 22, new Image("Images\\microsoftSurface.jpg"));
        Product aio5 = new Product("Asus", "Vivo", "i5-3570s | 8GB Ram | 120GB SSD", 499.99, 2018, 4, new Image("Images\\dell9010.jpg"));
        //Cameras
        Product cam1 = new Product("Nikon", "D5300", "18-55mm/70-300mm", 699.99, 2018, 6, new Image("Images\\nikonD5300.jpg"));
        Product cam2 = new Product("Canon", "EOS 80D DSLR", "18-55mm", 1499.99, 2018, 12, new Image("Images\\canonEOS.jpg"));
        Product cam3 = new Product("Nikon", "D5", "SLR BODY", 7999.99, 2018, 4, new Image("Images\\nikonD5.jpg"));
        Product cam4 = new Product("Sony", "a7", "28-70mm", 1399.99, 2018, 6, new Image("Images\\sonya7.jpg"));
        Product cam5 = new Product("FujiFilm", "X-T100", "15-45mm", 799.99, 2018, 3, new Image("Images\\fujifilmxT100.jpg"));


        //add laptops to Treemap
        addProduct("Laptop", lap1);
        addProduct("Laptop", lap2);
        addProduct("Laptop", lap3);
        addProduct("Laptop", lap4);
        addProduct("Laptop", lap5);

        addProduct("Phones", phone2);
        addProduct("Phones", phone1);
        addProduct("Phones", phone4);
        addProduct("Phones", phone3);

        addProduct("Desktop", Desk1);
        addProduct("Desktop", Desk4);
        addProduct("Desktop", Desk5);
        addProduct("Desktop", Desk2);
        addProduct("Desktop", Desk3);

        addProduct("All in One`s", aio3);
        addProduct("All in One`s", aio4);
        addProduct("All in One`s", aio1);
        addProduct("All in One`s", aio2);
        addProduct("All in One`s", aio5);

        addProduct("Cameras", cam1);
        addProduct("Cameras", cam2);
        addProduct("Cameras", cam3);
        addProduct("Cameras", cam4);
        addProduct("Cameras", cam5);

    }

    public static void addProduct(String category, Product product) {
        if (!inventoryMap.keySet().contains(category)) {
            inventoryMap.put(category, new LinkedList<>());
            inventoryMap.get(category).add(product);
        } else {
            inventoryMap.get(category).add(product);
        }
    }

    public static List getAllCategories() {
        List products = new ArrayList<>();
        for (Map.Entry<String, LinkedList<Product>> m : inventoryMap.entrySet())
            products.add(m.getKey());
        return products;
    }


    public static List getAllProducts() {
        List products = new ArrayList<>();
        for (Map.Entry<String, LinkedList<Product>> m : inventoryMap.entrySet()) {
            products.addAll(m.getValue());
        }
        return products;
    }

    public static List getProductFromCategory(String category) {
        List product = new ArrayList<>();
        for (Map.Entry m : inventoryMap.entrySet()) {
            if (m.getKey().equals(category)) {
                product.addAll((Collection) m.getValue());
            }
        }
        return product;
    }
}
