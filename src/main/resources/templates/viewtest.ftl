<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>hongyi-test</title>
    <meta name="referrer" content="always">
    <meta name="keywords" content="测试">
    <meta name="description" content="测试">
    <link rel="stylesheet" href="//cdn.bootcss.com/zui/1.10.0/css/zui.min.css">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/zui-red.css">
    <script src="//cdn.bootcss.com/zui/1.10.0/lib/jquery/jquery.js"></script>
    <script src="//cdn.bootcss.com/zui/1.10.0/js/zui.min.js"></script>
</head>
<body>
<form class="navbar-form navbar-left" role="search" action="/test/search" method="get">
    <div class="form-group">
        <input type="text" value="${manufactor!}" name="manufactor" maxlength="25" max="25" class="form-control"
               placeholder="搜索">
    </div>
    <button type="submit" class="btn btn-default"><i class="icon-search"></i> 搜索</button>
</form>
</body>
</html>