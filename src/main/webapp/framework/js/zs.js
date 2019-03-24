/**
 * 2017-2-21，张顺，这里写一些公共的方法，每个页面都会引用这个js
 */
function displayTime(){
	var date=new Date();
	var getYear=date.getFullYear();
	var getMonth=date.getMonth()+1;
	if(getMonth<10){
		getMonth="0"+getMonth;
	}
	var getDate=date.getDate();
	var getHours=date.getHours();
	var getMinutes=date.getMinutes();
	var getSeconds=date.getSeconds();
	var times=getYear+"-"+getMonth+"-"+getDate+" "+getHours+":"+getMinutes+":"+getSeconds;
	$("#nowTime").html(times);
	setTimeout("displayTime()",1000);
}