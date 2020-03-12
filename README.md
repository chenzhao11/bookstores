# bookstore

使用 Java Web 技术实现的一个简单网上书城系统。

里面需要改进的地方有很多，只是实现了基本功能，页面是最简单的页面，主要做的后端部分

# 文件结构

├─src
│  `│  c3p0-config.xml
│  `│  email_template.properties
│  `│  mailproperties.properties
│  `│
│  `└─com
│      `└─bookstore
│          `├─book
│          `│  ├─dao
│          `│  │      Bookdao.java
│          `│  │
│          `│  ├─service
│          `│  │      Bookservice.java
│          `│  │
│          `│  └─web
│          `│      └─servlet
│          `│              Bookservlet.java
│          `│
│         ` ├─cart
│          `│  ├─dao
│          `│  │      Cartdao.java
│          `│  │
│          `│  ├─domain
│          `│  │      Orderitem.java
│          `│  │
│          `│  ├─service
│          `│  │      Cartservice.java
│          `│  │
│          `│  └─web
│          `│      └─servlet
│          `│              Cartservlet.java
│          `│
│          `├─category
│          `│  ├─dao
│          `│  │      Categorydao.java
│          `│  │
│          `│  ├─domain
│          `│  │      Book.java
│          `│  │      Category.java
│          `│  │
│          `│  ├─service
│          `│  │      Categoryservice.java
│          `│  │
│          `│  └─web
│          `│      └─servlet
│          `│              Categoryservlet.java
│          `│
│         ` ├─order
│          `│  ├─dao
│          `│  │      Ordersdao.java
│          `│  │
│          `│  ├─domain
│          `│  │      Orderitem.java
│          `│  │      Orders.java
│          `│  │
│          `│  ├─service
│          `│  │      Ordersservice.java
│          `│  │
│          `│  └─web
│          `│      └─servlet
│          `│              Ordersservlet.java
│          `│
│          `└─user
│             ` ├─domain
│             ` │      User.java
│              `│
│              `├─user
│              `│  └─web
│              `│      └─servlet
│              `│              ActiveException.java
│              `│              UserException.java
│              `│              UserLoginException.java
│              `│              Userregistservlet.java
│              `│
│              `├─userdao
│              `│      Userdao.java
│              `│
│              `└─userservice
│                      `Userservice.java
│
└─WebContent
    `│  index.jsp
    `│
    `├─adminjsps
    `│  │  login.jsp
    `│  │  msg.jsp
    `│  │
    `│  └─admin
    `│      │  body.jsp
    `│      │  index.jsp
    `│      │  left.jsp
    `│      │  main.jsp
    `│      │  msg.jsp
    `│      │  top.jsp
    `│      │
    `│      ├─book
    `│      │      add.jsp
    `│      │      desc.jsp
    `│      │      list.jsp
    `│      │
   ` │      ├─category
    `│      │      add.jsp
    `│      │      del.jsp
    `│      │      list.jsp
    `│      │      mod.jsp
    `│      │
    `│      └─order
    │              list.jsp
    │
    ├─bank_img
    │      abc.bmp
    │      bc.bmp
    │      bcc.bmp
    │      beijingnongshang.bmp
    │      bh.bmp
    │      bj.bmp
    │      ccb.bmp
    │      cib.bmp
    │      cmb.bmp
    │      cmbc.bmp
    │      dy.bmp
    │      gf.bmp
    │      guangda.bmp
    │      hx.bmp
    │      icbc.bmp
    │      nanjing.bmp
    │      ningbo.bmp
    │      pingan.bmp
    │      post.bmp
    │      sfz.bmp
    │      sh.bmp
    │      shpd.bmp
    │      zheshang.bmp
    │      zx.bmp
    │
    ├─book_img
    │      20029394-1_l.jpg
    │      20285763-1_l.jpg
    │      20385925-1_l.jpg
    │      22722790-1_l.jpg
    │      22788412-1_l.jpg
    │      8758723-1_l.jpg
    │      8991366-1_l.jpg
    │      9265169-1_l.jpg
    │      9317290-1_l.jpg
    │
    ├─images
    │      all.png
    │      cart.png
    │      welcome.jpg
    │
    ├─jsps
    │  │  body.jsp
    │  │  left.jsp
    │  │  main.jsp
    │  │  msg.jsp
    │  │  top.jsp
    │  │
    │  ├─book
    │  │      desc.jsp
    │  │      list.jsp
    │  │
    │  ├─cart
    │  │      list.jsp
    │  │
    │  ├─order
    │  │      desc.jsp
    │  │      list.jsp
    │  │      msg.jsp
    │  │      send.jsp
    │  │
    │  └─user
    │          login.jsp
    │          regist.jsp
    │
    ├─menu
    │  │  mymenu.css
    │  │  mymenu.js
    │  │
    │  └─img
    │          jia.png
    │          jian.png
    │
    ├─META-INF
    │      MANIFEST.MF
    │
    ├─sql
    │      bookstore.sql
    │
    └─WEB-INF
        │  web.xml
        │
        ├─classes
        │      c3p0-config.xml
        │
        └─lib
                activation.jar
                c3p0-0.9.2-pre1.jar
                c3p0-oracle-thin-extras-0.9.2-pre1.jar
                commons-beanutils-1.8.3.jar
                commons-collections-3.2.1.jar
                commons-dbutils-1.4.jar
                commons-fileupload-1.2.2.jar
                commons-io-1.4.jar
                commons-lang-2.5.jar
                commons-logging-1.1.1.jar
                ezmorph-1.0.6.jar
                itcast-tools-1.4.2.jar
                itcast_0722.jar
                itcast_mail_1.0.jar
                json-lib-2.4-jdk15.jar
                jstl.jar
                mail.jar
                mchange-commons-0.2.jar
                mysql-connector-java-5.1.13-bin.jar
                standard.jar
                xom-1.1.jar
