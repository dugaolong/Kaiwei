package com.dgl.www.kaiwei;

/**
 *
 */
public class Constant {

    //设备信息
    public static String deviceid = "";
    public static String os = "";
    public static String nw = "";
    //baseurl
    public final static String URL_BASE = "https://api.github.com/users/";
//    public final static String URL_IFENG = "http://api.irecommend.ifeng.com/local.php?choicename=西安&choicetype=city&page=1" +
//            "&gv=5.6.4&av=5.6.4&uid=861735038272489&deviceid=861735038272489&proid=ifengnews&os=android_23" +
//            "&df=androidphone&vt=5&screen=1080x1920&publishid=6001&nw=wifi/ ";
    public final static String URL_IFENG = "http://api.irecommend.ifeng.com/";

    //ifeng返回的数据模型
    private String ifengResponse = "{" +
            "  'success': true," +
            "  'channelName': '西安'," +
            "  'channelType': 'city'," +
            "  'id': 'loc_xian'," +
            "  'data': {" +
            "    'list': {" +
            "      'totalPage': 3," +
            "      'item': [" +
            "        {" +
            "          'type': 'doc'," +
            "          'thumbnail': 'http://d.ifengimg.com/w201_h144_q100/p1.ifengimg.com/cmpp/2017/08/16/378864f7100a525a98bd62715ff6a11b_size42_w168_h120.jpg'," +
            "          'online': '1'," +
            "          'title': '未落实廉租房配建 西安15个商品房项目预售被暂停'," +
            "          'showType': '0'," +
            "          'source': '西部网'," +
            "          'subscribe': {" +
            "            'cateid': '西部网'," +
            "            'type': 'source'," +
            "            'catename': '西部网'," +
            "            'description': ''" +
            "          }," +
            "          'updateTime': '2017/08/16 11:55:34'," +
            "          'id': 'http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_086180005916660&channelKey=Y21wcF8xNzAwN183MTlfMzc2&channelid='," +
            "          'documentId': 'cmpp_086180005916660'," +
            "          'staticId': 'cmpp_086180005916660'," +
            "          'style': {" +
            "            'backreason': [" +
            "              '不感兴趣'," +
            "              '不想看:西部网'," +
            "              '内容质量差'," +
            "              '看过了'" +
            "            ]," +
            "            'view': 'titleimg'" +
            "          }," +
            "          'commentsUrl': 'http://sn.ifeng.com/a/20170816/5916660_0.shtml'," +
            "          'comments': '11'," +
            "          'commentsall': '48'," +
            "          'link': {" +
            "            'type': 'doc'," +
            "            'url': 'http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_086180005916660&channelKey=Y21wcF8xNzAwN183MTlfMzc2&channelid='," +
            "            'weburl': 'http://m.ifeng.com/sharenews.f?srctag=linksdk&aid=086180005916660'" +
            "          }," +
            "          'reftype': 'editor'" +
            "        }" +
            "      ]" +
            "    }," +
            "    'focus': {" +
            "      'totalPage': 1," +
            "      'item': [" +
            "        {" +
            "          'type': 'weatherForecast'" +
            "        }," +
            "        {" +
            "          'type': 'doc'," +
            "          'thumbnail': 'http://d.ifengimg.com/w576_h324/p3.ifengimg.com/cmpp/2017/08/17/9fab66b9e63554bd0c232a4ce01e1768_size310_w640_h360.jpg'," +
            "          'online': '1'," +
            "          'title': '西安：小区业主收房遇“买家秀”'," +
            "          'showType': '0'," +
            "          'source': '西部网'," +
            "          'subscribe': {" +
            "            'cateid': '西部网'," +
            "            'type': 'source'," +
            "            'catename': '西部网'," +
            "            'description': ''" +
            "          }," +
            "          'updateTime': '2017/08/17 08:36:58'," +
            "          'id': 'http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_086180005920048&channelKey=Y21wcF8xNzAwN183MTlfMzc3&channelid='," +
            "          'documentId': 'cmpp_086180005920048'," +
            "          'staticId': 'cmpp_086180005920048'," +
            "          'style': {" +
            "            'backreason': [" +
            "              '不感兴趣'," +
            "              '不想看:西部网'," +
            "              '内容质量差'," +
            "              '看过了'" +
            "            ]," +
            "            'view': 'titleimg'" +
            "          }," +
            "          'commentsUrl': 'http://sn.ifeng.com/a/20170817/5920048_0.shtml'," +
            "          'comments': '14'," +
            "          'commentsall': '60'," +
            "          'link': {" +
            "            'type': 'doc'," +
            "            'url': 'http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_086180005920048&channelKey=Y21wcF8xNzAwN183MTlfMzc3&channelid='," +
            "            'weburl': 'http://m.ifeng.com/sharenews.f?srctag=linksdk&aid=086180005920048'" +
            "          }," +
            "          'reftype': 'editor'" +
            "        }," +
            "        {" +
            "          'type': 'doc'," +
            "          'thumbnail': 'http://d.ifengimg.com/w576_h324/p2.ifengimg.com/cmpp/2017/08/16/0bd8efdafb600aaa185398981152652c_size446_w640_h360.jpg'," +
            "          'online': '1'," +
            "          'title': '陕西南郑撤县设区获国务院批复'," +
            "          'showType': '0'," +
            "          'source': '陕西传媒网——三秦都市报'," +
            "          'subscribe': {" +
            "            'cateid': '陕西传媒网——三秦都市报'," +
            "            'type': 'source'," +
            "            'catename': '陕西传媒网——三秦都市报'," +
            "            'description': ''" +
            "          }," +
            "          'updateTime': '2017/08/16 11:46:47'," +
            "          'id': 'http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_086180005916623&channelKey=Y21wcF8xNzAwN183MTlfMzc3&channelid='," +
            "          'documentId': 'cmpp_086180005916623'," +
            "          'staticId': 'cmpp_086180005916623'," +
            "          'style': {" +
            "            'backreason': [" +
            "              '不感兴趣'," +
            "              '不想看:陕西传媒网——三秦都市报'," +
            "              '内容质量差'," +
            "              '看过了'" +
            "            ]," +
            "            'view': 'titleimg'" +
            "          }," +
            "          'commentsUrl': 'http://sn.ifeng.com/a/20170816/5916623_0.shtml'," +
            "          'comments': '17'," +
            "          'commentsall': '74'," +
            "          'link': {" +
            "            'type': 'doc'," +
            "            'url': 'http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_086180005916623&channelKey=Y21wcF8xNzAwN183MTlfMzc3&channelid='," +
            "            'weburl': 'http://m.ifeng.com/sharenews.f?srctag=linksdk&aid=086180005916623'" +
            "          }," +
            "          'reftype': 'editor'" +
            "        }," +
            "        {" +
            "          'type': 'doc'," +
            "          'thumbnail': 'http://d.ifengimg.com/w576_h324/p1.ifengimg.com/cmpp/2017/08/15/d6586b0fb1c04c598a32847ae7fd8fbd_size328_w640_h360.jpg'," +
            "          'online': '1'," +
            "          'title': '西安楼市进入活跃期'," +
            "          'showType': '0'," +
            "          'source': '西安晚报'," +
            "          'subscribe': {" +
            "            'cateid': '西安晚报'," +
            "            'type': 'source'," +
            "            'catename': '西安晚报'," +
            "            'description': ''" +
            "          }," +
            "          'updateTime': '2017/08/15 09:01:21'," +
            "          'id': 'http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_086180005912962&channelKey=Y21wcF8xNzAwN183MTlfMzc3&channelid='," +
            "          'documentId': 'cmpp_086180005912962'," +
            "          'staticId': 'cmpp_086180005912962'," +
            "          'style': {" +
            "            'backreason': [" +
            "              '不感兴趣'," +
            "              '不想看:西安晚报'," +
            "              '内容质量差'," +
            "              '看过了'" +
            "            ]," +
            "            'view': 'titleimg'" +
            "          }," +
            "          'commentsUrl': 'http://sn.ifeng.com/a/20170815/5912962_0.shtml'," +
            "          'comments': '42'," +
            "          'commentsall': '366'," +
            "          'link': {" +
            "            'type': 'doc'," +
            "            'url': 'http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_086180005912962&channelKey=Y21wcF8xNzAwN183MTlfMzc3&channelid='," +
            "            'weburl': 'http://m.ifeng.com/sharenews.f?srctag=linksdk&aid=086180005912962'" +
            "          }," +
            "          'reftype': 'editor'" +
            "        }," +
            "        {" +
            "          'type': 'doc'," +
            "          'thumbnail': 'http://d.ifengimg.com/w576_h324/p2.ifengimg.com/cmpp/2017/08/14/41bea37fa6bb985b8579ff27a7241238_size417_w640_h360.jpg'," +
            "          'online': '1'," +
            "          'title': '最高检介入“8·10”事故调查'," +
            "          'showType': '0'," +
            "          'source': '新华通讯社'," +
            "          'subscribe': {" +
            "            'cateid': '新华通讯社'," +
            "            'type': 'source'," +
            "            'catename': '新华通讯社'," +
            "            'description': ''" +
            "          }," +
            "          'updateTime': '2017/08/14 08:35:38'," +
            "          'id': 'http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_086180005909273&channelKey=Y21wcF8xNzAwN183MTlfMzc3&channelid='," +
            "          'documentId': 'cmpp_086180005909273'," +
            "          'staticId': 'cmpp_086180005909273'," +
            "          'style': {" +
            "            'backreason': [" +
            "              '不感兴趣'," +
            "              '不想看:新华通讯社'," +
            "              '内容质量差'," +
            "              '看过了'" +
            "            ]," +
            "            'view': 'titleimg'" +
            "          }," +
            "          'commentsUrl': 'http://sn.ifeng.com/a/20170814/5909273_0.shtml'," +
            "          'comments': '200'," +
            "          'commentsall': '484'," +
            "          'link': {" +
            "            'type': 'doc'," +
            "            'url': 'http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_086180005909273&channelKey=Y21wcF8xNzAwN183MTlfMzc3&channelid='," +
            "            'weburl': 'http://m.ifeng.com/sharenews.f?srctag=linksdk&aid=086180005909273'" +
            "          }," +
            "          'reftype': 'editor'" +
            "        }" +
            "      ]" +
            "    }" +
            "  }" +
            "}";

}