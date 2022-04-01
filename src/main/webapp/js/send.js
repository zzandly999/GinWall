$(function () {
    var vue = new Vue({
        //首先先发送ajax请求要到用户注册的信息（id）
        data: {
            user: []
        },
        methods: {
            getAllUsers: function () {
                $.get(
                    "getAllUsers",
                    function (result) {
                        var user = result.extend.userList;
                        vue.user = user;
                    }
                )
            }
        },
        mounted: function () {
            this.getAllUsers();
        }
    });
})

function send() {
    $.post(
        "saveComments",
        function (result) {
            if(result.code == 100){
                window.location.href = "/mine";
            }else if(result.code == 200){
                console.log(result);
                alert("请检查文章类型与内容是否正确");
            }
        }
    )
}