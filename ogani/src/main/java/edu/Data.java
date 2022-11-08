package edu;

import edu.beans.Product;

import java.util.HashMap;
import java.util.Map;

public class Data {
    public static Map<String, Product> data = new HashMap<>();
    static {
        data.put("01",new Product("01", "Gầu bò Mỹ - 300g", "img/lab6/thitbo.jpg", "149.000đ", "",149000));
        data.put("02",new Product("02", "Bò tái Úc - 250g", "img/lab6/botai.jpg", "109.000đ", "",109000));
        data.put("03",new Product("03", "Sườn non heo C.P khay 500g", "img/lab6/heocp.jpg", "209.000đ", "",209000));
        data.put("04",new Product("04", "Cá chép khay 800g", "img/lab6/cachep.jpg", "199.000đ", "",199000));
        data.put("05",new Product("05", "Tôm thẻ khay 300g", "img/lab6/tom.jpg", "89.000đ", "",89000));
        data.put("06",new Product("06", "Ức gà phi lê 300g", "img/lab6/ucga.jpg", "39.000đ", "",39000));
        data.put("07",new Product("07", "Tôm thịt Đôi Đũa Vàng 31/40 gói 252g", "img/lab6/7.jpg", "149.000₫", "",149000));
        data.put("08",new Product("08", "Thịt càng ghẹ đông lạnh Phi Long khay 200g", "img/lab6/8.jpg", "128.000₫", "",128000));
        data.put("09",new Product("09", "Thịt càng ghẹ đông lạnh Ngon Ngon Food gói 250g", "img/lab6/9.jpg", "110.000₫", "",110000));
        data.put("10",new Product("10", "Thịt càng cua cúm đông lạnh Ngon Ngon Food gói 200g", "img/lab6/10.jpg", "100.000₫", "",100000));
        data.put("11",new Product("11", "Mực nang làm sạch Nghi Khánh khay 400g", "img/lab6/11.jpg", "99.000₫", "",99000));
        data.put("12",new Product("12", "Bạch tuộc làm sạch Nghi Khánh khay 400g", "img/lab6/12.jpg", "99.000₫", "",99000));
        data.put("13",new Product("13", "Cá bớp cắt khoanh đông lạnh Tuấn Nguyễn gói 300g", "img/lab6/13.jpg", "80.000₫", "",80000));
        data.put("14",new Product("14", "Cá thu cắt khoanh đông lạnh Tuấn Nguyễn gói 300g", "img/lab6/14.jpg", "80.000₫", "",80000));
        data.put("15",new Product("15", "Thịt ba rọi bò Mỹ Thảo Tiên Foods khay 300g", "img/lab6/15.jpg", "93.000₫", "",93000));
        data.put("16",new Product("16", "Ba chỉ bò Úc đông lạnh Thảo Tiên Foods khay 300g   ", "img/lab6/16.jpg", "70.000₫", "",70000));
        data.put("17",new Product("17", "Cá basa kho tộ Godaco gói 500g", "img/lab6/17.jpg", "52.000₫", "",52000));
        data.put("18",new Product("18", "Cá trứng loại 8 con TÂN HẢI HÒA 200g", "img/lab6/18.jpg", "39.000₫", "",39000));
        data.put("19",new Product("19", "Bò viên Tân Việt Sin 500g", "img/lab6/19.jpg", "105.000₫", "",105000));

    }
}
