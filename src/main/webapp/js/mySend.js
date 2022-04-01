$(function () {
    var vue = new Vue({
        el: "#mySendComments_body",
        data: {
            myCommentsList: []
        },
        methods: {
            getMyComments: function () {
                $.get(
                    "mySendCommentsWithUser",
                    function (result) {
                        var mySend = result.extend.myCommentsWithUser;
                        vue.myCommentsList = mySend;
                        console.log(result);
                    }
                )
            }
        },
        mounted: function () {
            this.getMyComments();
        }
    });
})