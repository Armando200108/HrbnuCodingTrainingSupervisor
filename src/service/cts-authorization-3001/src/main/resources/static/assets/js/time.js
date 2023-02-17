function getGreeting() {
    let date = new Date();
    let hour = date.getHours();
    let result = "晚上好！";
    if (hour >= 5 && hour < 11) {
        result = "早上好！";
    } else if (hour >= 11 && hour < 13) {
        result = "中午好！";
    } else if (hour >= 13 && hour < 18) {
        result = "下午好！";
    } else {
        result = "晚上好！";
    }
    return result;
}

window.onload = function () {
    document.getElementById('greeting').innerText = getGreeting();
}