function line() {

}
genChart();
var isLoaded = true;
function realTimeMonitor() {
    document.getElementById("monitor").disabled=true;
    isLoaded=true;
    setInterval(function () {
        isLoaded && genChart();
    },3000);
}

function closeMonitor() {
    isLoaded=false;
    document.getElementById("monitor").disabled=false;
    console.log("关闭监控")
}

function getAllDates(begin, end) {
    var dates = new Array();

    var beginArray = begin.split("-");
    var endArray = end.split("-");
    var beginDate = new Date();
    beginDate.setFullYear(beginArray[0], beginArray[1] - 1, beginArray[2])
    beginDate.setHours(00,00,00);
    var endDate = new Date();
    endDate.setFullYear(endArray[0], endArray[1] - 1, endArray[2])
    endDate.setHours(23,59,00);
    var beginTime = beginDate.getTime();
    var endTime = endDate.getTime();
    var i=0;
    for (var t = beginTime; t <= endTime;) {
        // console.log((new Date(parseInt(t))).format());
        // t = t + 60 * 1000;//每分钟
        t = t + 24*60*60*1000;//每天
        dates[i]=(new Date(parseInt(t))).format();
        i++;
    }
    return dates;
}

Date.prototype.format = function() {
    var s = '';
    var mouth = (this.getMonth() + 1)>=10?(this.getMonth() + 1):('0'+(this.getMonth() + 1));
    var day = this.getDate()>=10?this.getDate():('0'+this.getDate());
    var hour = this.getHours()>=10?this.getHours():('0'+this.getHours());
    var minutes = this.getMinutes()>=10?this.getMinutes():('0'+this.getMinutes());
    s += this.getFullYear() + '-'; // 获取年份。
    s += mouth + "-"; // 获取月份。
    s += day + ""; // 获取日。
    // s += hour + ":";
    // s += minutes;
    return (s); // 返回日期。
};
// getAllDates("2019-02-28", "2019-03-01");

function genChart() {
    console.log("a")
    $.ajax({
        url:'/demo/index/echarts/data',
        type:'GET',
        dataType:'json',
        beforeSend:function(){
            isLoaded=false;
        },
        success:function (data) {
            console.log("success")
            console.log(data);
            drawChart(data);
            isLoaded=true;
        }
    })
}

var dates = getAllDates("2019-01-01", "2020-01-01");

function dataToDate(data) {
    var date = new Array();
    for (var i = 0; i <data.length ; i++) {
        date[i]=data[i].orTime;
    }
    console.log(date);
    return date;
}

function dataToOrder(data) {
    var numMap = new Map();
    for (var i = 0; i <data.length ; i++) {
        // num[i]=data[i].orNum;
        numMap.set(data[i].orTime,data[i].orNum);
    }
    return numMap;
}

function mapToNums(data) {
    var nums = new Array();
    var nummap= dataToOrder(data)
    for (var i = 0; i < dates.length; i++) {
        if(nummap.has(dates[i])){
            nums[i]=nummap.get(dates[i]);
        }else {
            nums[i]=0;
        }

    }
    return nums;
}
function getStyle(el, name)
{
    if (window.getComputedStyle(el, null)) {
        return window.getComputedStyle(el, null);
    } else {
        return el.currentStyle;
    }
}
//为图表计算高度
function chartssize(container, charts) {

    var wi = getStyle(container, 'width').width;
    var hi = getStyle(container, 'height').height;
    charts.style.height = hi;
}
function drawChart(data) {
    var che = document.getElementById("main");
    this.chartssize(document.getElementById("dddd"),che);
    var myChart = echarts.init(che);
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: 'ECharts 入门示例'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:['销量']
        },
        xAxis: {
            data: dates
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'line',
            data: mapToNums(data)
        }],
        dataZoom:[
            {
                type:'slider'
            },
            {
                type:'inside'
            }
        ]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    //建议加上以下这一行代码，不加的效果图如下（当浏览器窗口缩小的时候）。超过了div的界限（红色边框）
    window.addEventListener('resize', function () {
        myChart.resize()
    });

}