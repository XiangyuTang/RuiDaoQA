/**显示用户信息*/	
function change11() {
	document.getElementById("bodyRight").innerHTML="<iframe width='1   168px' " +
			"height='600px' name='mainFrame' frameborder='no' scrolling='No'  " +
			"noresize='noresize' id='mainFrame' title='mainFrame' class='id' src='UserMessageServlet'></iframe>";
}

/**显示书本信息*/
function changeView() {
	document.getElementById("bodyRight").innerHTML="<iframe width='1168px' " +
			"height='600px' name='mainFrame' frameborder='no' scrolling='No'  " +
			"noresize='noresize' id='mainFrame' title='mainFrame' class='id' src='FansMessageServlet'></iframe>";
}

/**显示关注信息*/
function changeGuanzhu(){
	document.getElementById("bodyRight").innerHTML="<iframe width='1168px' " +
		"height='600px' name='mainFrame' frameborder='no' scrolling='No'  " +
		"noresize='noresize' id='mainFrame' title='mainFrame' class='id' src='GuanZhuServlet'></iframe>";
}
/**验证管理员登录账号密码*/
function fun01() {
	var id = document.getElementById("userName").value;
	var pwd = document.getElementById("L_pass").value;

	if (id.length == 0) {
		alert("用户名（邮箱）不能为空！");
		return false;
	}
	
	if (pwd.length == 0) {
		alert("密码不能为空");
		return false;
	}
}

/**编辑用户信息验证*/
function modifyUser() {
	var name = document.getElementById("name").value;
	var pwd = document.getElementById("pwd").value;
	var sex = document.getElementById("sex").value;
	var birth = document.getElementById("birth").value;
	var telephone = document.getElementById("telephone").value;
	var postCode = document.getElementById("postCode").value;
	var address = document.getElementById("address").value;
	var trueName = document.getElementById("trueName").value;
	var balance = document.getElementById("balance").value;
	
	if (name.length == 0) {
		alert("用户名不能为空！");
		return false;
	}
	
	if (pwd.length == 0) {
		alert("密码不能为空");
		return false;
	}
	
	if (sex.length == 0) {
		alert("性别不能为空！");
		return false;
	}
	
	if (birth.length == 0) {
		alert("生日不能为空");
		return false;
	}
	
	if (telephone.length == 0) {
		alert("电话号码不能为空！");
		return false;
	}
	
	if (postCode.length == 0) {
		alert("邮编不能为空");
		return false;
	}
	
	if (address.length == 0) {
		alert("地址不能为空！");
		return false;
	}
	
	if (trueName.length == 0) {
		alert("真实姓名不能为空");
		return false;
	}
	
	if (balance.length == 0 ) {
		alert("余额不能为空！");
		return false;
	} else if(isNaN(balance)) {
		alert("余额只能为数字！");
		return false;
	}
	
}

/**增加用户信息验证*/
function addUser() {
	var name = document.getElementById("addName").value;
	var pwd = document.getElementById("addPwd").value;
	var sex = document.getElementById("addSex").value;
	var birth = document.getElementById("addBirth").value;
	var telephone = document.getElementById("addTelephone").value;
	var postCode = document.getElementById("addPostCode").value;
	var address = document.getElementById("addAddress").value;
	var trueName = document.getElementById("addTrueName").value;
	var balance = document.getElementById("addBalance").value;
	
	if (name.length == 0) {
		alert("用户名不能为空！");
		return false;
	}
	
	if (pwd.length == 0) {
		alert("密码不能为空");
		return false;
	}
	if (sex.length == 0) {
		alert("性别不能为空！");
		return false;
	}
	
	if (birth.length == 0) {
		alert("生日不能为空");
		return false;
	}
	if (telephone.length == 0) {
		alert("电话号码不能为空！");
		return false;
	}
	
	if (postCode.length == 0) {
		alert("邮编不能为空");
		return false;
	}
	if (address.length == 0) {
		alert("地址不能为空！");
		return false;
	}
	
	if (trueName.length == 0) {
		alert("真实姓名不能为空");
		return false;
	}
	if (balance.length == 0 ) {
		alert("余额不能为空！");
		return false;
	} else if(isNaN(balance)) {
		alert("余额只能为数字！");
		return false;
	}
	
}

/** 显示增加窗体 */
/**var showHide = function(obj) {
	var overDiv = document.getElementById("overLook");
	overDiv.style.display = "block";
}*/

/** 查看用户信息 */
var lookTr = function(obj) {
	var overDiv = document.getElementById("overLook");
	overDiv.style.display = "block";
	
//	var overDiv = document.getElementById("hideTd");
//	overDiv.style.display = "block";
	var overId = document.getElementById("hideId");
	overId.style.display = "block";
	// 通过按钮来获得tr;
	var tr = obj.parentNode.parentNode;
	// 获得需要查看的内容
	var user_id = tr.cells[0].innerHTML;
	var nick_name = tr.cells[1].innerHTML;
	var Sex = tr.cells[2].innerHTML;
	var Birth = tr.cells[3].innerHTML;
	var Email = tr.cells[4].innerHTML;
	var Introduce = tr.cells[5].innerHTML;
	var Password = tr.cells[6].innerHTML;
	
//	overDiv.style.display = "none";
	overId.style.display = "none";
	// 获得遮罩层的tbody
	var tb = document.getElementById("overLook_tb");
	// 获得tb中所有的input
	var inputs = tb.getElementsByTagName("input");
	// 往遮罩层中的input填入从表格中取得来的数据
	inputs[0].value = user_id;
	inputs[1].value = nick_name;
	inputs[2].value = Sex;
	inputs[3].value = Birth;
	inputs[4].value = Email;
	inputs[5].value = Introduce;
	inputs[6].value = Password;
}

/**取消查看*/
var cancelLook = function(obj) {
	var overDiv = document.getElementById("overLook");
	overDiv.style.display = "none";
}

/**取消修改信息*/
var modifyMes = function(obj) {
	var overDiv = document.getElementById("overLook1");
	overDiv.style.display = "none";
}

/**取消增加信息*/
var cancelAddMes = function(obj) {
	var overDiv = document.getElementById("overLook2");
	overDiv.style.display = "none";
}

/**显示增加*/
var userAdd = function(obj) {
	var overDiv = document.getElementById("overLook2");
	overDiv.style.display = "block";
}

/**显示登录*/
var showLogin = function(obj) {
	var overDiv = document.getElementById("login_over");
	overDiv.style.display = "block";
}

/**取消登录*/
var cancelLogin = function(obj) {
	var overDiv = document.getElementById("login_over");
	overDiv.style.display = "none";
}

/**判断查询用户名*/
function fun(){
	var type = document.getElementById("type").value;
	
	if(type==""){
		alert("输入内容不能为空！");
		return false;
	}
}

/** 修改学生信息 */
var modifyTr = function(obj) {
	var overDiv = document.getElementById("overLook1");
	overDiv.style.display = "block";
	
	// 通过按钮来获得tr;
	var tr = obj.parentNode.parentNode;
	var overId = document.getElementById("hideId");
	overId.style.display = "block";
	// 获得需要查看的内容
	var user_id = tr.cells[0].innerHTML;
	var nickname = tr.cells[1].innerHTML;
	var Sex = tr.cells[2].innerHTML;
	var Birthday = tr.cells[3].innerHTML;
	var Email = tr.cells[4].innerHTML;
	var introduce = tr.cells[5].innerHTML;
	var password = tr.cells[6].innerHTML;
	
	overId.style.display = "none";
	// 获得遮罩层的tbody
	var tb = document.getElementById("overLook_tb1");
	// 获得tb中所有的input
	var inputs = tb.getElementsByTagName("input");
	// 往遮罩层中的input填入从表格中取得来的数据
	inputs[0].value = user_id;
	inputs[1].value = nickname;
	inputs[2].value = Sex;
	inputs[3].value = Birthday;
	inputs[4].value = Email;
	inputs[5].value = introduce;
	inputs[6].value = password;
}

/**跳转注册页面*/
function skipRegister() {
	document.getElementById("front_inside").innerHTML="<iframe width='1000px' " +
			"height='673px' name='mainFrame' frameborder='no' scrolling='No'  " +
			"noresize='noresize' id='mainFrame' title='mainFrame' class='id' src='/bookstore/user/register.jsp'></iframe>";
}

/**跳转书本信息*/
function skipBookMes() {
	document.getElementById("front_inside").innerHTML="<iframe width='1000px' " +
			"height='673px' name='mainFrame' frameborder='no' scrolling='No'  noresize='noresize' " +
			"id='mainFrame' title='mainFrame' class='id' src='/bookstore/user/bookMessage.jsp'></iframe>";
}

/**判断查询书本名*/
function bookName(){
	var type = document.getElementById("theBookName").value;
	
	if(type==""){
		alert("输入内容不能为空！");
		return false;
	}
}

/** 查看商品信息 */
var lookBook = function(obj) {
	var overDiv = document.getElementById("overLook");
	overDiv.style.display = "block";
	
	// 通过按钮来获得tr;
	var tr = obj.parentNode.parentNode;
	// 获得需要查看的内容
	var isbn = tr.cells[0].innerHTML;
	var bookName = tr.cells[1].innerHTML;
	var author= tr.cells[2].innerHTML;
	var price = tr.cells[3].innerHTML;
	var publish = tr.cells[4].innerHTML;
	var details = tr.cells[5].innerHTML;
	var inventory = tr.cells[6].innerHTML;
	var type = tr.cells[7].innerHTML;
	var showImage = tr.cells[8].innerHTML;
	// 获得遮罩层的tbody
	var tb = document.getElementById("overLook_tb");
	// 获得tb中所有的input
	var inputs = tb.getElementsByTagName("input");
	// 往遮罩层中的input填入从表格中取得来的数据
	inputs[0].value = isbn;
	inputs[1].value = bookName;
	inputs[2].value = author;
	inputs[3].value = price;
	inputs[4].value = publish;
	inputs[5].value = details;
	inputs[6].value = inventory;
	inputs[7].value = type;
	var image = tb.getElementsByTagName("img");
	image[0].src = showImage;
}

/**修改商品信息*/
var modifyBooks = function(obj) {
	var overDiv = document.getElementById("overLook1");
	overDiv.style.display = "block";
	
	// 通过按钮来获得tr;
	var tr = obj.parentNode.parentNode;
	// 获得需要查看的内容
	var isbn = tr.cells[0].innerHTML;
	var bookName = tr.cells[1].innerHTML;
	var author= tr.cells[2].innerHTML;
	var price = tr.cells[3].innerHTML;
	var publish = tr.cells[4].innerHTML;
	var details = tr.cells[5].innerHTML;
	var inventory = tr.cells[6].innerHTML;
	var type = tr.cells[7].innerHTML;
	var showImage = tr.cells[8].innerHTML;
	// 获得遮罩层的tbody
	var tb = document.getElementById("overLook_tb1");
	// 获得tb中所有的input
	var inputs = tb.getElementsByTagName("input");
	// 往遮罩层中的input填入从表格中取得来的数据
	inputs[0].value = isbn;
	inputs[1].value = bookName;
	inputs[2].value = author;
	inputs[3].value = price;
	inputs[4].value = publish;
	inputs[5].value = details;
	inputs[6].value = inventory;
	inputs[7].value = type;
	inputs[8].value = showImage;
}

/**编辑书本信息*/
function modifyGoods() {
	var isbn = document.getElementById("isbn").value;
	var bookName = document.getElementById("bookName").value;
	var author = document.getElementById("author").value;
	var price = document.getElementById("price").value;
	var publish = document.getElementById("publish").value;
	var details = document.getElementById("details").value;
	var inventory = document.getElementById("inventory").value;	
	var type = document.getElementById("type").value;
	var showImage = document.getElementById("showImage").value;
	
	if (isbn.length == 0) {
		alert("ISBN不能为空！");
		return false;
	}
	
	if (bookName.length == 0) {
		alert("书名不能为空");
		return false;
	}
	if (author.length == 0) {
		alert("作者不能为空！");
		return false;
	}
	
	if (price.length == 0) {
		alert("价格不能为空");
		return false;
	} else if (isNaN(price)){
		alert("价格只能为数字");
		return false;
	}
	if (publish.length == 0) {
		alert("出版社不能为空！");
		return false;
	}
	
	if (details.length == 0) {
		alert("图书详情不能为空");
		return false;
	}
	if (inventory.length == 0) {
		alert("库存不能为空！");
		return false;
	} else if (isNaN(inventory)){
		alert("库存只能为数字");
		return false;
	}
	
	if (showImage.length == 0 ) {
		alert("图片展示不能为空！");
		return false;
	} 	
}

/**添加书本*/
function addGoods() {
	var addIsbn = document.getElementById("addIsbn").value;
	var addBookName = document.getElementById("addBookName").value;
	var addAuthor = document.getElementById("addAuthor").value;
	var addPrice = document.getElementById("addPrice").value;
	var addPublish = document.getElementById("addPublish").value;
	var addDetails = document.getElementById("addDetails").value;
	var addinventory = document.getElementById("addinventory").value;	
	var addType = document.getElementById("addType").value;
	var addShowImage = document.getElementById("addShowImage").value;
	
	if (addIsbn.length == 0) {
		alert("ISBN不能为空！");
		return false;
	}
	
	if (addBookName.length == 0) {
		alert("书名不能为空");
		return false;
	}
	if (addAuthor.length == 0) {
		alert("作者不能为空！");
		return false;
	}
	
	if (addPrice.length == 0) {
		alert("价格不能为空");
		return false;
	} else if (isNaN(addPrice)){
		alert("价格只能为数字");
		return false;
	}
	if (addPublish.length == 0) {
		alert("出版社不能为空！");
		return false;
	}
	
	if (addDetails.length == 0) {
		alert("图书详情不能为空");
		return false;
	}
	if (addinventory.length == 0) {
		alert("库存不能为空！");
		return false;
	} else if (isNaN(addinventory)){
		alert("库存只能为数字");
		return false;
	}
	
	if (addType.length == 0 ) {
	   alert("类型不能为空！");
		return false;
	} 	
	
	if (addShowImage.length == 0 ) {
		alert("图片展示不能为空！");
		return false;
	} 	
}

/**上一页*/
function preButton(){
    window.open("PrePageServlet");
    form.submit();  
 }

/**下一页*/
function nextButton(){
    window.open("NextPageServlet");
    form.submit();  
 }

