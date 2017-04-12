/**
 * Created by MOAB on 3/27/2017.
 */

// Injecting JQuery, comments and commentsData
define([ 'jquery', 'comments', 'commentsData' ], function($) {

	$(function() {
		var saveComment = function(data) {

			// Convert pings to human readable format
			$(data.pings).each(
					function(index, id) {
						var user = usersArray.filter(function(user) {
							return user.id == id
						})[0];
						data.content = data.content.replace('@' + id, '@'
								+ user.fullname);
					});

			return data;
		};
		$('#comments-container').comments({
			profilePictureURL : 'img/common/commentAvatar.png',
			currentUserId : 1,
			roundProfilePictures : true,
			textareaRows : 1,
			enableAttachments : true,
			enableHashtags : true,
			enablePinging : true,
			getUsers : function(success, error) {
				setTimeout(function() {

					success(usersArray);
				}, 500);
			},
			getComments : function(success, error) {
				setTimeout(function() {

					success(commentsArray);
				}, 500);
			},
			postComment : function(data, success, error) {
				setTimeout(function() {
					success(saveComment(data));
				}, 500);
			},
			putComment : function(data, success, error) {
				setTimeout(function() {
					success(saveComment(data));
				}, 500);
			},
			deleteComment : function(data, success, error) {
				setTimeout(function() {
					success();
				}, 500);
			},
			upvoteComment : function(data, success, error) {
				setTimeout(function() {
					success(data);
				}, 500);
			},
			uploadAttachments : function(dataArray, success, error) {
				setTimeout(function() {
					success(dataArray);
				}, 500);
			}
		});
	});
})