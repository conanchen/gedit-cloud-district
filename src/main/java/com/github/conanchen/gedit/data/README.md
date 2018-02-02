# 行政区域
## 1. 使用行政区划数据 
[城市编码表](http://a.amap.com/lbs/static/zip/AMap_adcode_citycode.zip)

## 2. 针对每一个行政区如110100，调用高德API获取行政区信息,保存到dst110100.json文件
[高德API获取行政区信息](https://restapi.amap.com/v3/config/district?keywords=110100&subdistrict=1&key=dc0b8c635b9ea4c1bd0d35716fd01f96)


# POI
## 1. 针对每一个行政区adcode如110100，高德周边搜索API获取半径50000米以内POI信息，第1页数据保存到poi010000p1.json文件
city的adcode可从{行政区划数据}找到，location可从如110100.json文件内的"center": "116.407394,39.904211"获取,
page最大可翻到100页
[高德周边搜索API获取POI信息](http://restapi.amap.com/v3/place/around?offset=25&page=1&city=110000&radius=50000&location=116.407394,39.904211&key=dc0b8c635b9ea4c1bd0d35716fd01f96)  

## 2. 使用POI分类编码 
[POI分类编码](http://a.amap.com/lbs/static/zip/AMap_poicode.zip)
如果需要按行业分类查找poi信息，可以再加一个参数：types，其值可从POI分类编码poicode.csv获取  
 010100为加油站（中类）
如限制为加油站：http://restapi.amap.com/v3/place/around?types=010100&offset=25&page=1&city=110000&radius=50000&location=116.407394,39.904211&key=dc0b8c635b9ea4c1bd0d35716fd01f96

# ID查询搜索API服务地址：
 
 http://restapi.amap.com/v3/place/detail?id=B000A7I1TH&key=dc0b8c635b9ea4c1bd0d35716fd01f96