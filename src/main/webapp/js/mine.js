// $(function () {
//     var vue = new Vue({
//         el: "#showComments_body",
//         data: {
//             whoCommentList:[]
//         },
//         methods: {
//             who: function (name) {
//                 $.post(
//                     "toWho",
//                     "nickName="+name,
//                     function (result) {
//                         console.log(result);
//                         var who = result.extend.whoComment;
//                         vue.whoCommentList = who;
//                     }
//                 )
//             }
//         },
//         mounted: function () {
//             this.who(name);
//         }
//     });
// })