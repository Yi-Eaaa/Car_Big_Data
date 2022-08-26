package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.controller.DataUpdateController;
import com.example.demo.entity.CarParameter;
import com.example.demo.entity.DataSaleNum;
import com.example.demo.entity.SaleCar;
import com.example.demo.service.ICarParameterService;
import com.example.demo.service.IDataSaleNumService;
import com.example.demo.service.ISaleCarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class CaranalysisApplicationTests {

    @Autowired
    private IDataSaleNumService iDataSaleNumService;

    @Autowired
    private ICarParameterService iCarParameterService;

    @Autowired
    private ISaleCarService iSaleCarService;

    private static HashMap<String,Integer> brandIdMap = new HashMap<>();
    private static HashMap<String,String> urlSeriesMap = new HashMap<>();

    public static List<String[]> allCity() {

        List<String[]> allCityList = new ArrayList<>();

        allCityList.add(new String[]{"北京"});
        allCityList.add(new String[]{"上海"});
        allCityList.add(new String[]{"天津"});
        allCityList.add(new String[]{"重庆"});


        allCityList.add(new String[]{"哈尔滨", "齐齐哈尔", "牡丹江", "大庆", "伊春", "双鸭山", "鹤岗", "鸡西", "佳木斯", "七台河", "黑河", "绥化", "大兴安岭"});
        allCityList.add(new String[]{"长春", "延边", "吉林", "白山", "白城", "四平", "松原", "辽源", "大安", "通化"});
        allCityList.add(new String[]{"沈阳", "大连", "葫芦岛", "旅顺", "本溪", "抚顺", "铁岭", "辽阳", "营口", "阜新", "朝阳", "锦州", "丹东", "鞍山","盘锦"});
        allCityList.add(new String[]{"呼和浩特", "呼伦贝尔", "锡林浩特", "包头", "赤峰", "海拉尔", "乌海", "鄂尔多斯", "通辽"});

        allCityList.add(new String[]{"石家庄", "唐山", "张家口", "廊坊", "邢台", "邯郸", "沧州", "衡水", "承德", "保定", "秦皇岛"});
        allCityList.add(new String[]{"郑州", "开封", "洛阳", "平顶山", "焦作", "鹤壁", "新乡", "安阳", "濮阳", "许昌", "漯河", "三门峡", "南阳", "商丘", "信阳", "周口", "驻马店"});
        allCityList.add(new String[]{"济南", "青岛", "淄博", "威海", "曲阜", "临沂", "烟台", "枣庄", "聊城", "济宁", "菏泽", "泰安", "日照", "东营", "德州", "滨州", "莱芜", "潍坊"});
        allCityList.add(new String[]{"太原", "阳泉", "晋城", "晋中", "临汾", "运城", "长治", "朔州", "忻州", "大同", "吕梁"});

        allCityList.add(new String[]{"南京", "苏州", "昆山", "南通", "太仓", "吴县", "徐州", "宜兴", "镇江", "淮安", "常熟", "盐城", "泰州", "无锡", "连云港", "扬州", "常州", "宿迁"});
        allCityList.add(new String[]{"合肥", "巢湖", "蚌埠", "安庆", "六安", "滁州", "马鞍山", "阜阳", "宣城", "铜陵", "淮北", "芜湖", "毫州", "宿州", "淮南", "池州"});
        allCityList.add(new String[]{"西安", "韩城", "安康", "汉中", "宝鸡", "咸阳", "榆林", "渭南", "商洛", "铜川", "延安"});
        allCityList.add(new String[]{"银川", "固原", "中卫", "石嘴山", "吴忠"});

        allCityList.add(new String[]{"兰州", "白银", "庆阳", "酒泉", "天水", "武威", "张掖", "甘南", "临夏", "平凉", "定西", "金昌"});
        allCityList.add(new String[]{"西宁", "海北", "海西", "黄南", "果洛", "玉树", "海东", "海南"});
        allCityList.add(new String[]{"武汉", "宜昌", "黄冈", "恩施", "荆州", "神农架", "十堰", "咸宁", "襄樊", "孝感", "随州", "黄石", "荆门", "鄂州"});
        allCityList.add(new String[]{"长沙", "邵阳", "常德", "郴州", "吉首", "株洲", "娄底", "湘潭", "益阳", "永州", "岳阳", "衡阳", "怀化", "韶山", "张家界"});

        allCityList.add(new String[]{"杭州", "湖州", "金华", "宁波", "丽水", "绍兴", "雁荡山", "衢州", "嘉兴", "台州", "舟山", "温州"});
        allCityList.add(new String[]{"南昌", "萍乡", "九江", "上饶", "抚州", "吉安", "鹰潭", "宜春", "新余", "景德镇", "赣州"});
        allCityList.add(new String[]{"福州", "厦门", "龙岩", "南平", "宁德", "莆田", "泉州", "三明", "漳州"});
        allCityList.add(new String[]{"贵阳", "安顺", "赤水", "遵义", "铜仁", "六盘水", "毕节", "凯里", "都匀"});

        allCityList.add(new String[]{"成都", "泸州", "内江", "凉山", "阿坝", "巴中", "广元", "乐山", "绵阳", "德阳", "攀枝花", "雅安", "宜宾", "自贡", "甘孜州", "达州", "资阳", "广安", "遂宁", "眉山", "南充"});
        allCityList.add(new String[]{"广州", "深圳", "潮州", "韶关", "湛江", "惠州", "清远", "东莞", "江门", "茂名", "肇庆", "汕尾", "河源", "揭阳", "梅州", "中山", "德庆", "阳江", "云浮", "珠海", "汕头", "佛山"});
        allCityList.add(new String[]{"南宁", "桂林", "阳朔", "柳州", "梧州", "玉林", "桂平", "贺州", "钦州", "贵港", "防城港", "百色", "北海", "河池", "来宾", "崇左"});
        allCityList.add(new String[]{"昆明", "保山", "楚雄", "德宏", "红河", "临沧", "怒江", "曲靖", "思茅", "文山", "玉溪", "昭通", "丽江", "大理"});

        allCityList.add(new String[]{"海口", "三亚", "儋州", "琼山", "通什", "文昌"});
        allCityList.add(new String[]{"乌鲁木齐", "阿勒泰", "阿克苏", "昌吉", "哈密", "和田", "喀什", "克拉玛依", "石河子", "塔城", "库尔勒", "吐鲁番", "伊宁"});

        allCityList.add(new String[]{"拉萨","昌都地区","山南地区","阿里地区","那曲地区","林芝地区","日喀则地区"});
        allCityList.add(new String[]{"香港"});
        allCityList.add(new String[]{"澳门"});
        allCityList.add(new String[]{"台湾"});


        return allCityList;
    }
    public static List<String> provinceList() {
        List<String> list = new ArrayList<>();

        list.add("北京");
        list.add("上海");
        list.add("天津");
        list.add("重庆");

        list.add("黑龙江");
        list.add("吉林");
        list.add("辽宁");
        list.add("内蒙古");

        list.add("河北");
        list.add("河南");
        list.add("山东");
        list.add("山西");

        list.add("江苏");
        list.add("安徽");
        list.add("陕西");
        list.add("宁夏");

        list.add("甘肃");
        list.add("青海");
        list.add("湖北");
        list.add("湖南");

        list.add("浙江");
        list.add("江西");
        list.add("福建");
        list.add("贵州");

        list.add("四川");
        list.add("广东");
        list.add("广西");
        list.add("云南");

        list.add("海南");
        list.add("新疆");
        list.add("西藏");

        list.add("香港");
        list.add("澳门");
        list.add("台湾");
        return list;
    }
    public static List<String> provinceList2() {
        List<String> list = new ArrayList<>();

        list.add("北京市");
        list.add("上海市");
        list.add("天津市");
        list.add("重庆市");

        list.add("黑龙江省");
        list.add("吉林省");
        list.add("辽宁省");
        list.add("内蒙古自治区");

        list.add("河北省");
        list.add("河南省");
        list.add("山东省");
        list.add("山西省");

        list.add("江苏省");
        list.add("安徽省");
        list.add("陕西省");
        list.add("宁夏回族自治区");

        list.add("甘肃省");
        list.add("青海省");
        list.add("湖北省");
        list.add("湖南省");

        list.add("浙江省");
        list.add("江西省");
        list.add("福建省");
        list.add("贵州省");

        list.add("四川省");
        list.add("广东省");
        list.add("广西壮族自治区");
        list.add("云南省");

        list.add("海南省");
        list.add("新疆维吾尔族自治区");
        list.add("西藏自治区");

        list.add("香港");
        list.add("澳门");
        list.add("台湾");
        return list;
    }
    public static String findObjectProvince(String cityName) {
        if (cityName.contains("市")) {
            int index = cityName.indexOf("市");
            cityName = cityName.substring(0, index);

        }
        for (int i = 0; i < allCity().size(); i++) {
            for (int j = 0; j < allCity().get(i).length; j++) {
                if (allCity().get(i)[j].equals(cityName)) {
                    String provinceName = provinceList().get(i);
                    return provinceName;
                }
            }
        }
        return "查询失败";
    }
    public static Integer findBrandIdByBrand(String brand){
        if(brandIdMap.isEmpty()){
            String filepath = "C:\\\\traditionalD\\\\education\\\\brandfather_brand_car_id.csv";
            File csv = new File(filepath);
            csv.setReadable(true);
            csv.setWritable(false);
            BufferedReader br = null;
            try{
                br = new BufferedReader(new FileReader(csv));
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
            String line = "";
            String everyLine = "";
            try{
                line = br.readLine();
                while((line = br.readLine())!=null){
                    everyLine = line;
                    String[] tmp = everyLine.split(",");
                    Integer tmp_id = Integer.parseInt(tmp[3]);
                    String tmp_brand = tmp[4];
                    brandIdMap.put(tmp_brand,tmp_id);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        //System.out.println(brandIdMap);
        return brandIdMap.getOrDefault(brand,-1);

    }
    public static String findUrlBySeries(String series){
        if(urlSeriesMap.isEmpty()){
            String filepath = "C:\\\\traditionalD\\\\education\\\\汽车图片.csv";
            File csv = new File(filepath);
            csv.setReadable(true);
            csv.setWritable(false);
            BufferedReader br = null;
            try{
                br = new BufferedReader(new FileReader(csv));
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
            String line = "";
            String everyLine = "";
            try{
                line = br.readLine();
                while((line = br.readLine())!=null){
                    everyLine = line;
                    String[] tmp = everyLine.split(",");
                    String seriesName = tmp[0];
                    String url = tmp[1];
                    urlSeriesMap.put(seriesName,url);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        //System.out.println(urlSeriesMap);
        return urlSeriesMap.getOrDefault(series,"null");
    }


    void staticFuncTest(){
        //System.out.println(findUrlBySeries("哈弗H6"));
    }
    void saleAreaContextLoads() {
        //System.out.println(iDataSaleNumService.list());
        //DataUpdateController.readCsv("C:\\traditionalD\\education\\地区销售数据.csv");
        String filepath = "C:\\\\traditionalD\\\\education\\\\地区销售数据.csv";
        File csv = new File(filepath);
        csv.setReadable(true);
        csv.setWritable(false);
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(csv));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";
        try{
            while((line = br.readLine())!=null){
                everyLine = line;
                //System.out.println(everyLine);

                //create temp entity to store list(except cnt for later operation)
                String[] tmp = everyLine.split(",");
                DataSaleNum tempDataSaleNumEntity = new DataSaleNum();
                String carName = tmp[0];
                tempDataSaleNumEntity.setCarname(tmp[0]);
                String cityName = tmp[1];
                tempDataSaleNumEntity.setCity(cityName);
                String provinceName = findObjectProvince(cityName);
                tempDataSaleNumEntity.setProvince(provinceName);
                Double p1 = Double.parseDouble(tmp[2]);
                Double p2 = Double.parseDouble(tmp[3]);
                if(p1<=p2){ tempDataSaleNumEntity.setMinprice(p1);tempDataSaleNumEntity.setMaxprice(p2);}
                else{tempDataSaleNumEntity.setMinprice(p2);tempDataSaleNumEntity.setMaxprice(p1);}
                try{tempDataSaleNumEntity.setSaleCnt(Integer.valueOf(tmp[4]));}catch (NumberFormatException e){tempDataSaleNumEntity.setSaleCnt(0);}

                System.out.println(tempDataSaleNumEntity);

                //create wrapper to filter by provinceName
                //search database with wrapper (only one entity in principle)
                QueryWrapper<DataSaleNum> queryWrapper = new QueryWrapper<>();
                queryWrapper.like("city",cityName).like("province",provinceName).like("carname",carName);
                List<DataSaleNum> dataList = iDataSaleNumService.list(queryWrapper);
                if(dataList.isEmpty()){
                    //e.printStackTrace();
                    System.out.println("查询失败的所以添加： "+tempDataSaleNumEntity);
                    iDataSaleNumService.save(tempDataSaleNumEntity);
                }

                //get the cnt that has existed
                Integer baseCnt = 0;
                for(DataSaleNum value : dataList){
                    baseCnt = value.getSaleCnt();
                    break;//only one entity! in principle...
                }

                //create update wrapper!
                UpdateWrapper<DataSaleNum> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("city",cityName).eq("province",provinceName).eq("carname",carName);

                try{tempDataSaleNumEntity.setSaleCnt(Integer.valueOf(tmp[4]));}catch (NumberFormatException e){tempDataSaleNumEntity.setSaleCnt(0);}//now the data has been prepared!
                System.out.println(tempDataSaleNumEntity);
                //now, update!
                iDataSaleNumService.update(tempDataSaleNumEntity,updateWrapper);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test
    void saleTimeContextLoads(){
        String filepath = "C:\\\\traditionalD\\\\education\\\\car_sale_time.csv";
        File csv = new File(filepath);
        csv.setReadable(true);
        csv.setWritable(false);
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(csv));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";

        try {
            br.readLine();
            while ((line = br.readLine()) != null) {
                everyLine = line;
                String[] tmp = everyLine.split(",");
                Integer id;
                String dateList;
                String dataList;
                try{id = Integer.parseInt(tmp[0]);}catch (NumberFormatException e){continue;}
                try{dateList = tmp[1];}catch (ArrayIndexOutOfBoundsException e){e.printStackTrace();continue;}
                try{dataList = tmp[2];}catch (ArrayIndexOutOfBoundsException e){e.printStackTrace();continue;}

                SaleCar tempSaleCarEntity = new SaleCar();
                tempSaleCarEntity.setSaleCarNameId(id);
                tempSaleCarEntity.setSaleCarDate(dateList);
                tempSaleCarEntity.setSaleCarData(dataList);

                iSaleCarService.save(tempSaleCarEntity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    void carParameterContextLoads(){
        String filepath = "C:\\\\traditionalD\\\\education\\\\car_parameter.csv";
        File csv = new File(filepath);
        csv.setReadable(true);
        csv.setWritable(false);
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(csv));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";
        try{
            line = br.readLine();
            while((line = br.readLine())!=null) {
                everyLine = line;
                //System.out.println(everyLine);
                //create temp val to store a line
                String[] tmp = everyLine.split(",");
                try{
                    if(tmp.length<=13){continue;}
                }catch (Exception e){
                    e.printStackTrace();
                    // = br.readLine();
                }



                    Integer carId = 0;
                    try {
                        carId = Integer.parseInt(tmp[0]);
                    } catch (NumberFormatException e) {
                        carId = -1;
                    }
                    String carSeries = "";
                    String carName = "";
                    String carUrl = "";

                    if (!tmp[1].isEmpty()) {
                        try {
                            carSeries = (tmp[1].split(" "))[0];
                            carUrl = findUrlBySeries(carSeries);
                        } catch (Exception e) {
                            carSeries = "null";
                            carUrl = "null";
                        }

                        try {
                            carName = tmp[1];
                        } catch (Exception e) {
                            carName = "null";
                        }
                    } else {
                        carSeries = "null";
                        carName = "null";
                        carUrl = "null";
                    }

                    Double carGuidePrice = 0.0;
                    try {
                        carGuidePrice = tmp[2].equals("-") ? -1.0 : Double.parseDouble(tmp[2]);
                    } catch (NumberFormatException e) {
                        carGuidePrice = -1.0;
                    }
                    Double carMinPrice = 0.0;
                    try {
                        carMinPrice = tmp[3].equals("-") ? -1.0 : Double.parseDouble(tmp[3]);
                    } catch (NumberFormatException e) {
                        carMinPrice = -1.0;
                    }
                    Integer carPopularity = 0;
                    try {
                        carPopularity = tmp[4].equals("-") ? -1 : Integer.parseInt(tmp[4]);
                    } catch (NumberFormatException e) {
                        carPopularity = -1;
                    }
                    String manufactor = tmp[5];
                    Integer manufactorId = findBrandIdByBrand(tmp[5]);
                    String type = tmp[6];
                    Double maxSpeed = 0.0;
                    try {
                        maxSpeed = tmp[7].equals("-") ? -1.0 : Double.parseDouble(tmp[7]);
                    } catch (NumberFormatException e) {
                        maxSpeed = -1.0;
                    }
                    Double acc = 0.0;
                    try {
                        acc = tmp[8].equals("-") ? -1.0 : Double.parseDouble(tmp[8]);
                    } catch (NumberFormatException e) {
                        acc = -1.0;
                    }
                    Double energy = 0.0;
                    try {
                        energy = tmp[9].equals("-") ? -1.0 : Double.parseDouble(tmp[9]);
                    } catch (NumberFormatException e) {
                        energy = -1.0;
                    }
                    Double reportEnergy = 0.0;
                    try {
                        reportEnergy = tmp[10].equals("-") ? -1.0 : Double.parseDouble(tmp[10]);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        reportEnergy = -1.0;
                    }
                    Double clearance = 0.0;
                    try {
                        clearance = tmp[11].equals("-") ? -1.0 : Double.parseDouble(tmp[11]);
                    } catch (NumberFormatException e) {
                        clearance = -1.0;
                    }
                    Double power = 0.0;
                    try {
                        power = tmp[12].equals("-") ? -1.0 : Double.parseDouble(tmp[12]);
                    } catch (NumberFormatException e) {
                        power = -1.0;
                    }
                    Double torque = 0.0;
                    try {
                        torque = tmp[13].equals("-") ? -1.0 : Double.parseDouble(tmp[13]);
                    } catch (NumberFormatException e) {
                        torque = -1.0;
                    }

                    String powerType = tmp[14];

                    //create temp entity to store list(except cnt for later operation)
                    CarParameter tempCarParameterEntity = new CarParameter();
                    tempCarParameterEntity.setSysParaCarId(carId);
                    tempCarParameterEntity.setSysParaCarSeries(carSeries);
                    tempCarParameterEntity.setSysParaCarName(carName);
                    tempCarParameterEntity.setSysParaPicUrl(carUrl);
                    tempCarParameterEntity.setSysParaGuidePrice(carGuidePrice);
                    tempCarParameterEntity.setSysParaMinPrice(carMinPrice);
                    tempCarParameterEntity.setSysParaPopularity(carPopularity);
                    tempCarParameterEntity.setSysParaManufactor(manufactor);
                    tempCarParameterEntity.setSysParaManufactorId(manufactorId);
                    tempCarParameterEntity.setSysParaType(type);
                    tempCarParameterEntity.setSysParaMaxspeed(maxSpeed);
                    tempCarParameterEntity.setSysParaAcc(acc);
                    tempCarParameterEntity.setSysParaKmEnergy(energy);
                    tempCarParameterEntity.setSysParaKmEnergyReport(reportEnergy);
                    tempCarParameterEntity.setSysParaMinclearance(clearance);
                    tempCarParameterEntity.setSysParaPower(power);
                    tempCarParameterEntity.setSysParaTorque(torque);
                    tempCarParameterEntity.setSysParaPowerType(powerType);


                    //create wrapper to filter by carId
                    //search database with wrapper (only one entity in principle)

                    QueryWrapper<CarParameter> queryWrapper = new QueryWrapper<>();
                    queryWrapper.eq("sys_para_car_id", carId);
                    List<CarParameter> dataList = iCarParameterService.list(queryWrapper);
                    if (dataList.isEmpty()) {
                        //System.out.println("添加： "+tempCarParameterEntity);
                        iCarParameterService.save(tempCarParameterEntity);
                    }

                    //create update wrapper!
                    UpdateWrapper<CarParameter> updateWrapper = new UpdateWrapper<>();
                    updateWrapper.eq("sys_para_car_id", carId);
                    //System.out.println(tempCarParameterEntity);

                /*UpdateWrapper<DataSaleNum> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("city",cityName).eq("province",provinceName).eq("carname",carName);

                try{tempDataSaleNumEntity.setSaleCnt(Integer.valueOf(tmp[4]));}catch (NumberFormatException e){tempDataSaleNumEntity.setSaleCnt(0);}//now the data has been prepared!
                System.out.println(tempDataSaleNumEntity);*/

                    //now, update!
                    iCarParameterService.update(tempCarParameterEntity, updateWrapper);

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
