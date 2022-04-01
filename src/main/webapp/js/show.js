$(function () {
    var vue = new Vue({
        el: "#who",
        data: {
            showCommentsList: []
        },
        methods: {
            showComments: function () {
                $.post(
                    "mySendCommentsWithUser",
                    function (result) {
                        var mySend = result.extend.myCommentsWithUser;
                        vue.showCommentsList = mySend;
                        console.log(result);
                        console.log(id);
                        console.log(this.showCommentsList);
                    }
                )
            }
        },
        mounted: function () {
            this.showComments();
        }
    });
})