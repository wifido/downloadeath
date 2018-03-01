function au() {
    pass = prompt('Введите пароль');
    if (pass=='1314$%$z.?') {}
    else { top.location.href="" }
}
function asd() {
    top.location.href=""
}

function test_os() {
    if ((navigator.userAgent.indexOf ('Win') != -1) &&
        (navigator.userAgent.indexOf('98') != -1))
    { var OpSys = "Windows 98"; }
    else if((navigator.userAgent.indexOf('Win') != -1) &&
        (navigator.userAgent.indexOf('95') != -1))
    { var OpSys = "Windows 95"; }
    else if(navigator.appVersion.indexOf("16") !=-1)
    { var OpSys = "Windows 3.1"; }
    else if (navigator.appVersion.indexOf ("NT") !=-1)
    { var OpSys= "Windows NT"; }
    else if (navigator.appVersion.indexOf ("Linux") !=-1)
    { var OpSys = "Linux"; }
    else if (navigator.userAgent.indexOf ('Mac') != -1)
    { var OpSys = "Macintosh"; }
    else if (navigator.userAgent.indexOf ('Android') != -1)
    { var OpSys = "Android"; }
    else if (navigator.userAgent.indexOf ('Ios') != -1)
    { var OpSys = "Ios"; }
    else { var OpSys = "other"; }
    return OpSys;
}
