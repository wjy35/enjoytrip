"use strict";(self["webpackChunkenjoytrip"]=self["webpackChunkenjoytrip"]||[]).push([[198],{6539:function(t,e,o){o.d(e,{Z:function(){return n}});var a=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("b-row",[o("b-icon",{attrs:{id:"before-page",icon:"arrow-left-circle-fill"},on:{click:t.beforeSite}})],1)},s=[],l={data(){return{}},methods:{beforeSite(){this.$router.go(-1)}}},r=l,c=o(1001),i=(0,c.Z)(r,a,s,!1,null,"9fd720ce",null),n=i.exports},2876:function(t,e,o){o.r(e),o.d(e,{default:function(){return w}});var a=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("b-container",{staticClass:"p-5"},[o("BeforeSite"),o("b-row",[o("b-col"),o("b-col",{attrs:{cols:"6"}},[o("p",{staticClass:"text-center font-weight-bold",attrs:{id:"article-detail"}},[t._v("세부 사항")])]),o("b-col")],1),o("b-row",[o("b-col"),o("b-col",{attrs:{cols:"10"}},[o("div",{attrs:{id:"form-title"}},[t._v(t._s(t.article.subject))])]),o("b-col")],1),o("b-row",{staticClass:"pt-3"},[o("b-col"),o("b-col",{staticClass:"text-left",attrs:{cols:"5"}},[t._v(t._s(t.article.currentUpdate))]),o("b-col",{staticClass:"text-right",attrs:{cols:"5"}},[t._v("작성자 : "+t._s(t.article.userId))]),o("b-col")],1),o("b-row",{staticClass:"pt-3"},[o("b-col"),o("b-col",{attrs:{cols:"10"}},[o("b-form-textarea",{attrs:{readonly:"",id:"textarea-large",size:"lg",value:t.article.content}})],1),o("b-col")],1),o("b-row",{staticClass:"pt-3"},[o("b-col"),o("b-col",{attrs:{cols:"10"}},[t.imageUrl&&t.imageUrl.length>0?o("div",{attrs:{id:"imageUrlTemplate"}},[o("b-col",{attrs:{cols:"10"}},t._l(t.imageUrl,(function(t,e){return o("img",{key:e,attrs:{src:t,id:"imageShow"}})})),0)],1):t._e()]),o("b-col")],1),o("b-row",{staticClass:"mt-2"},[o("b-col"),t.article.userId==this.$store.state.userStore.userId?o("b-col",{staticClass:"text-right",attrs:{cols:"10"}},[o("b-button",{staticClass:"m-1",attrs:{id:"modifyBoardButton"},on:{click:t.modifyBoard}},[t._v("수정")]),o("b-button",{attrs:{id:"deleteBoardButton"},on:{click:t.deleteBoard}},[t._v("삭제")])],1):t._e(),o("b-col")],1),o("CommentList",{attrs:{boardId:parseInt(this.$route.params.boardId)}})],1)},s=[],l=(o(7658),o(9810)),r=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",{attrs:{id:"commentContainer"}},[o("b-row",{staticClass:"p-3"},[o("b-col"),o("b-col",{attrs:{cols:"10",id:"commentTitle"}},[t._v(" 댓글 "+t._s(t.commentList.length)+"개 ")]),o("b-col")],1),t._l(t.commentList,(function(e){return o("commentItem",{key:e.id,attrs:{comment:e},on:{deleteComment:t.deleteComment,modifyCommentComplete:t.modifyCommentComplete}})})),o("b-row",{staticClass:"pt-2"},[o("b-col"),o("b-col",{attrs:{cols:"9"}},[o("b-form-textarea",{staticStyle:{width:"100%"},attrs:{id:"textarea-large",size:"lg",placeholder:"댓글을 입력해주세요"},model:{value:t.content,callback:function(e){t.content=e},expression:"content"}})],1),o("b-col",{attrs:{cols:"1"}},[o("b-button",{staticStyle:{height:"100%"},on:{click:t.submitComment}},[t._v(" 입력 ")])],1),o("b-col")],1)],2)},c=[],i=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("b-container",{staticClass:"m-3"},[o("b-row",[o("b-col"),o("b-col",{attrs:{cols:"2"}},[o("b-row",[t._v("프로필 사진")]),o("b-row",[t._v(t._s(t.comment.userId))])],1),o("b-col",{attrs:{cols:"8"}},[o("b-row",[t.isModify?o("span",[o("b-form-textarea",{attrs:{id:"textarea-large",size:"sm",placeholder:"내용을 입력해주세요"},model:{value:t.content,callback:function(e){t.content=e},expression:"content"}}),o("b-button",{attrs:{id:"submitButton"},on:{click:t.modifyCommentComplete}},[t._v("저장")])],1):o("span",[t._v(" "+t._s(t.comment.content)+" ")])]),o("b-row",{staticStyle:{"font-size":"15px"}},[t._v(" "+t._s(t.comment.currentUpdate)+" ")]),t.comment.userId==this.$store.state.userStore.userId?o("b-row",{staticStyle:{"font-size":"12px"}},[o("span",{staticClass:"mr-1",on:{click:t.modifyComment}},[t._v("수정 ")]),o("span",{on:{click:t.deleteComment}},[t._v("삭제")])]):t._e()],1),o("b-col")],1)],1)},n=[],d={data(){return{isModify:!1,content:""}},props:{comment:{type:Object,required:!0}},methods:{deleteComment(){console.log("deleteComment"),this.$emit("deleteComment",this.comment.commentId)},modifyComment(){console.log("modifyComment"),this.isModify=!this.isModify},modifyCommentComplete(){console.log("modifyCommentComplete"),console.log(this.comment.commentId,this.content),this.$emit("modifyCommentComplete",this.comment.commentId,this.content),this.isModify=!this.isModify}}},m=d,h=o(1001),u=(0,h.Z)(m,i,n,!1,null,"0e4745d0",null),b=u.exports,p=o(3822),g={props:{boardId:{type:Number,required:!0}},data(){return{commentList:[],content:""}},components:{commentItem:b},methods:{submitComment(){""!=this.content?(l.Z.post(`/comment/${this.boardId}`,{boardId:this.boardId,content:this.content,userId:this.$store.state.userStore.userId}).then((t=>{console.log(t.data),l.Z.get(`/comment/${this.boardId}`).then((t=>{console.log(t.data),this.commentList=t.data.response})).catch((t=>{console.log(t)}))})).catch((t=>{console.log(t)})),alert("댓글이 등록되었습니다."),this.content=""):alert("댓글을 입력해주세요")},deleteComment(t){console.log(t),l.Z["delete"](`/comment/${this.boardId}/${t}`).then((t=>{console.log(t.data),alert("댓글이 삭제되었습니다."),l.Z.get(`/comment/${this.boardId}`).then((t=>{console.log(t.data),this.commentList=t.data.response})).catch((t=>{console.log(t)}))})).catch((t=>{console.log(t)}))},modifyCommentComplete(t,e){console.log(t,e),l.Z.put(`/comment/${t}`,{content:e,boardId:this.boardId,userId:this.$store.state.userStore.userId}).then((t=>{console.log(t.data),alert("댓글이 수정되었습니다."),l.Z.get(`/comment/${this.boardId}`).then((t=>{console.log(t.data),this.commentList=t.data.response})).catch((t=>{console.log(t)}))})).catch((t=>{alert(t)}))}},created(){l.Z.get(`/comment/${this.boardId}`).then((t=>{console.log(t.data),this.commentList=t.data.response})).catch((t=>{console.log(t)}))},computed:{...(0,p.rn)("userStore",["isLogin","userId"]),rows(){return this.endPage*this.perPage}}},f=g,C=(0,h.Z)(f,r,c,!1,null,"9588d152",null),v=C.exports,I=o(6539),_={computed:{...(0,p.rn)("userStore",["isLogin","userId"])},name:"CommunityDetail",data(){return{article:{boardId:0,subject:"",content:"",userId:"",hit:0,currentUpdate:""},imageUrl:[]}},methods:{modifyBoard(){this.$router.push({name:"boardmodify",params:{boardId:this.$route.params.boardId}})},deleteBoard(){console.log(this.$route.params.boardId),l.Z["delete"](`/board/${this.$route.params.boardId}`).then((t=>{console.log(t.data.response),alert("삭제되었습니다."),this.$router.push("/community/list/1")}))}},created(){console.log(this.$route.params.boardId),l.Z.get(`/board/${this.$route.params.boardId}`).then((t=>{console.log(t.data.response),this.article=t.data.response,console.log(this.article.content)})),l.Z.post(`/board/hit/${this.$route.params.boardId}`).then((t=>{console.log(t.data.response)})).catch((t=>{console.log(t)})),l.Z.get(`/board/file/${this.$route.params.boardId}`).then((t=>{console.log(t.data.response),this.imageUrl=[],t.data.response.map((t=>{this.imageUrl.push(t.fileUrl)})),console.log(this.imageUrl)})).catch((t=>{console.log(t),this.imageUrl=[]}))},components:{CommentList:v,BeforeSite:I.Z}},$=_,y=(0,h.Z)($,a,s,!1,null,"14d237da",null),w=y.exports},6094:function(t,e,o){o.r(e),o.d(e,{default:function(){return g}});var a=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("b-container",{staticClass:"p-5"},[o("b-row",[o("b-col"),o("b-col",{attrs:{cols:"6"}},[o("p",{staticClass:"text-center font-weight-bold",attrs:{id:"article-modify"}},[t._v("글 수정 ")])]),o("b-col")],1),o("b-row",[o("b-col"),o("b-col",{attrs:{cols:"10"}},[o("b-form-input",{attrs:{placeholder:t.article.subject,id:"form-title"},model:{value:t.article.subject,callback:function(e){t.$set(t.article,"subject",e)},expression:"article.subject"}})],1),o("b-col")],1),o("b-row",{staticClass:"p-3"}),o("b-row",[o("b-col"),o("b-col",{attrs:{cols:"10"}},[o("b-form-textarea",{attrs:{id:"textarea-large",size:"lg",placeholder:t.article.content},model:{value:t.article.content,callback:function(e){t.$set(t.article,"content",e)},expression:"article.content"}})],1),o("b-col")],1),o("UploadButton"),o("b-row",{staticClass:"mt-2"},[o("b-col"),o("b-col",{attrs:{cols:"10"}},[o("b-button",{attrs:{id:"submitButton"},on:{click:t.saveArticle}},[t._v("저장")])],1),o("b-col")],1)],1)},s=[],l=(o(7658),o(9810)),r=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",[o("b-row",{staticClass:"mt-2",attrs:{id:"uploadButtonTemplate"}},[o("b-col"),o("b-col",{attrs:{cols:"5"}},[o("input",{ref:"fileInput",attrs:{accept:"image/*",type:"file",multiple:""},on:{change:t.handleFileInputChange}})]),o("b-col",{attrs:{cols:"5"}},[o("b-button",{attrs:{id:"uploadImageButton"},on:{click:t.uploadImage}},[t._v("사진 업로드")])],1),o("b-col")],1),o("b-row",[o("b-col"),o("b-col",{attrs:{cols:"10"}},[t.imageUrl!=[]?o("div",{attrs:{id:"imageUrlTemplate"}},[o("b-col",{attrs:{cols:"10"}},t._l(t.imageUrl,(function(t,e){return o("img",{key:e,attrs:{src:t,id:"imageShow"}})})),0)],1):t._e()]),o("b-col")],1)],1)},c=[],i={data(){return{selectedFile:[],imageUrl:[],fileList:[]}},methods:{handleFileInputChange(t){this.selectedFile=t.target.files,console.log(this.selectedFile)},uploadImage(){if(0==this.selectedFile.length)return void alert("이미지가 없습니다.");console.log(this.selectedFile);const t=new FormData;for(let e=0;e<this.selectedFile.length;e++)t.append("files",this.selectedFile[e]),console.log(this.selectedFile[e]);console.log(t),l.Z.post("/board/multiFileUploadTest",t,{headers:{"Content-Type":"multipart/form-data"}}).then((t=>{console.log("Response Data",t.data)})).catch((t=>{console.log(t)}))}}},n=i,d=o(1001),m=(0,d.Z)(n,r,c,!1,null,"503d3507",null),h=m.exports,u={data(){return{article:{title:"",content:"",userId:"",hit:0,boardType:""}}},components:{UploadButton:h},methods:{saveArticle(){console.log(this.article.boardId),console.log(this.article),l.Z.put(`/board/${this.$route.params.boardId}`,this.article).then((t=>{console.log(t.data),alert("게시글이 수정되었습니다."),this.$router.push({name:"boardview",params:{boardId:this.$route.params.boardId}})})).catch((t=>{console.log(t),alert("게시글이 수정 중 오류가 발생하였습니다"),this.$router.push({name:"boardview",params:{boardId:this.$route.params.boardId}})}))}},created(){console.log(this.$route.params.boardId),l.Z.get(`/board/${this.$route.params.boardId}`).then((t=>{console.log(t.data.response),this.article=t.data.response}))}},b=u,p=(0,d.Z)(b,a,s,!1,null,"4f6694e2",null),g=p.exports},9737:function(t,e,o){o.r(e),o.d(e,{default:function(){return m}});var a=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("b-container",{attrs:{id:"hot-place-article-item-detail"}},[o("BeforeSite"),o("b-row",[o("b-col"),o("b-col",{attrs:{cols:"6"}},[o("p",{staticClass:"text-center font-weight-bold",attrs:{id:"hot-place-text"}},[t._v("핫플 공유")])]),o("b-col")],1),o("b-row",{staticClass:"p-3"},[o("b-col",{staticClass:"text-center",staticStyle:{"font-size":"30px"},attrs:{id:"file-upload"}},[t._v(" "+t._s(t.article.hotPlaceName)+" ")])],1),o("b-row",[o("b-col",[t._v(" 작성자 : "+t._s(t.article.userId))]),o("b-col",{attrs:{cols:"6"}}),o("b-col",{staticClass:"text-right"},[t._v(t._s(t.article.createAt))])],1),o("b-row",{staticClass:"pt-3"},[t.article.imageUrl?o("b-col",{staticClass:"text-center"},[o("img",{attrs:{src:t.article.imageUrl,id:"imageShow"}})]):t._e()],1),t.article.content?o("b-row",{staticClass:"pt-3"},[o("b-col",[o("b-form-textarea",{attrs:{readonly:"",id:"textarea-large",size:"sm",value:t.article.content}})],1)],1):t._e()],1)},s=[],l=o(2844),r=o(6539),c={data(){return{article:{}}},methods:{},created(){l.Z.get(`/hotplace/article/${this.$route.params.hotPlaceArticleId}`).then((t=>{console.log(t.data),this.article=t.data.response}))},components:{BeforeSite:r.Z}},i=c,n=o(1001),d=(0,n.Z)(i,a,s,!1,null,"72a1bf3b",null),m=d.exports},8360:function(t,e,o){o.r(e),o.d(e,{default:function(){return C}});var a=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("b-container",{staticClass:"m-3",attrs:{id:"hot-place-detail-container"}},[o("BeforeSite"),o("b-row",[o("b-col"),o("b-col",[o("HotPlaceItem",{attrs:{hotPlace:t.hotPlace}})],1),o("b-col")],1),o("b-row",[o("b-col"),o("b-col",{staticClass:"text-center",attrs:{cols:"8",id:"vote-text"}},[t._v(" 좋아요 수를 "+t._s(this.hotPlace.vote)+"개나 받았어요 ! ")]),o("b-col")],1),o("b-row",{staticClass:"pt-3"},[o("b-col"),o("b-col",{staticClass:"text-center"},[o("b-button",{staticStyle:{width:"200px",height:"50px"},on:{click:t.clickVote}},[t._v(" 투표하기 ")])],1),o("b-col")],1),o("b-row",{staticClass:"p-3"},[o("b-col",{attrs:{id:"file-upload"}},[t._v(" 상위 태그 5개 ")])],1),o("b-row",[o("b-col"),t._l(t.tags,(function(e){return o("b-col",{key:e.tagName,staticClass:"tag p-1 text-center",attrs:{cols:"2"},on:{click:t.selectTag}},[o("b-button",{attrs:{id:"hot-place-button"}},[t._v(" "+t._s(e.tagName)+" ")])],1)})),o("b-col")],2),o("b-row",{staticClass:"p-3"},[o("b-col",{attrs:{id:"file-upload"}},[t._v(" 핫플 바로 가기 ")])],1),o("b-row",[o("b-button",{staticStyle:{width:"100%"},on:{click:function(e){return t.goToKakaoMapUrl()}}},[t._v("카카오맵 바로가기")])],1),o("b-row",{staticClass:"p-3 mt-2"},[o("b-col",{attrs:{id:"file-upload"}},[t._v(" 유저들의 의견 ")])],1),t._l(t.hotPlaceArticles,(function(t,e){return o("HotPlaceArticlesItem",{key:e,attrs:{article:t}})}))],2)},s=[],l=o(5514),r=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("b-container",{staticClass:"p-2",attrs:{id:"hot-place-article-container"},on:{click:t.articleDetail}},[o("b-row",[o("b-col",{attrs:{id:"hot-place-article-userid"}},[t._v(" "+t._s(t.article.userId)+" 님의 의견 ")]),o("b-col",{attrs:{cols:"6"}}),o("b-col",{staticClass:"text-right"},[t._v(" "+t._s(t.article.createAt)+" ")])],1)],1)},c=[],i=(o(7658),{methods:{articleDetail(){console.log(this.article.hotPlaceArticleId),this.$router.push({name:"hotPlaceArticleView",params:{hotPlaceArticleId:this.article.hotPlaceArticleId}})}},props:{article:{type:Object,required:!0}}}),n=i,d=o(1001),m=(0,d.Z)(n,r,c,!1,null,"342494c0",null),h=m.exports,u=o(2844),b=o(6539),p={data(){return{hotPlace:{},vote:100,isVote:!1,tags:[],hotPlaceArticles:[]}},methods:{selectTag(){},clickVote(t){this.isVote?u.Z.post(`/hotplace/${this.$route.params.hotPlaceId}/unvote`).then((e=>{console.log(e.data),alert("투표를 취소합니다."),this.isVote=!this.isVote,this.isVote?t.target.style.backgroundColor="var(--primary-color)":t.target.style.backgroundColor="#6c757d",u.Z.get(`/hotplace/${this.$route.params.hotPlaceId}`).then((t=>{console.log(t.data.response),this.hotPlace=t.data.response}))})).catch((t=>{console.log(t)})):u.Z.post(`/hotplace/${this.$route.params.hotPlaceId}/vote`).then((e=>{console.log(e.data),alert("투표했습니다."),this.isVote=!this.isVote,this.isVote?t.target.style.backgroundColor="var(--primary-color)":t.target.style.backgroundColor="#6c757d",u.Z.get(`/hotplace/${this.$route.params.hotPlaceId}`).then((t=>{console.log(t.data.response),this.hotPlace=t.data.response}))})).catch((t=>{console.log(t)}))},goToKakaoMapUrl(){console.log(this.hotPlace.placeUrl),window.open(this.hotPlace.placeUrl)}},components:{HotPlaceItem:l.Z,HotPlaceArticlesItem:h,BeforeSite:b.Z},created(){console.log(this.$route.params.hotPlaceId),u.Z.get(`/hotplace/${this.$route.params.hotPlaceId}`).then((t=>{console.log(t.data.response),this.hotPlace=t.data.response})),u.Z.get(`/hotplace/articleAll/${this.$route.params.hotPlaceId}`).then((t=>{console.log(t.data),this.hotPlaceArticles=t.data.response})),u.Z.get(`/hotplace/${this.$route.params.hotPlaceId}/tag`).then((t=>{console.log(t.data),this.tags=t.data.response}))}},g=p,f=(0,d.Z)(g,a,s,!1,null,"beccbe8a",null),C=f.exports},5514:function(t,e,o){o.d(e,{Z:function(){return d}});var a=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",{staticClass:"p-2"},[o("div",{attrs:{id:"circle-item"},on:{click:t.hotplaceDetail}},[o("RandomPhoto",{staticClass:"circle-image",attrs:{alt:"이미지",id:"hotPlaceImage"}}),o("div",{staticClass:"circle-text"},[t._v(t._s(t.hotPlace.hotPlaceName))])],1)])},s=[],l=(o(7658),o(4159)),r={data(){return{imageUrl:""}},components:{RandomPhoto:l.Z},methods:{hotplaceDetail(){this.$router.push({name:"hotPlaceDetail",params:{hotPlaceId:this.hotPlace.hotPlaceId}}).catch((t=>{console.log(t)}))}},props:{hotPlace:{type:Object,required:!0}}},c=r,i=o(1001),n=(0,i.Z)(c,a,s,!1,null,"2f3e2a2a",null),d=n.exports},9810:function(t,e,o){var a=o(4161);e["Z"]=a.Z.create({baseURL:"http://localhost:4029/",headers:{"Content-Type":"application/json;charset=utf-8"}})},2844:function(t,e,o){o.d(e,{p:function(){return r}});var a=o(4161),s=o(9239);const l=(0,s.Bt)();async function r(t,e,o){await l.get("/v2/local/search/category.json",{params:t}).then(e).catch(o)}e["Z"]=a.Z.create({baseURL:"http://localhost:4029/",headers:{"Content-Type":"application/json;charset=utf-8"}})},9239:function(t,e,o){o.d(e,{Bt:function(){return l},ay:function(){return r},sz:function(){return c}});var a=o(4161);const s="access-token";function l(){return a.Z.create({baseURL:"https://dapi.kakao.com",headers:{Authorization:"KakaoAK f77f215fff512191ee1b1fc61abf5150"}})}function r(){return a.Z.create({baseURL:"https://apis-navi.kakaomobility.com",headers:{Authorization:"KakaoAK f77f215fff512191ee1b1fc61abf5150","Content-Type":"application/json"}})}function c(){return a.Z.create({baseURL:"http://localhost:4029",headers:{"Content-Type":"application/json;charset=utf-8",[`${s}`]:sessionStorage.getItem(s)}})}}}]);
//# sourceMappingURL=board.762337a8.js.map