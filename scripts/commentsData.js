/**
 * Created by MOAB on 3/27/2017.
 */


var commentsArray = [

    {
        "id": 1,
        "parent": null,
        "created": "2015-01-01",
        "modified": "2015-01-01",
        "content": "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed posuere interdum sem. Quisque ligula eros ullamcorper quis, lacinia quis facilisis sed sapien. Mauris varius diam vitae arcu.",
        "pings": [],
        "creator": 6,
        "fullname": "Raj Kumar",
        "profile_picture_url": "img/common/commentAvatar.png",
        "created_by_admin": false,
        "created_by_current_user": false,
        "upvote_count": 3,
        "user_has_upvoted": false
    },
    {
        "id": 2,
        "parent": null,
        "created": "2015-01-02",
        "modified": "2015-01-02",
        "content": "Sed posuere interdum sem. Quisque ligula eros ullamcorper quis, lacinia quis facilisis sed sapien. Mauris varius diam vitae arcu.",
        "pings": [],
        "creator": 5,
        "fullname": "Administrator",
        "profile_picture_url": "img/common/commentAvatar.png",
        "created_by_admin": true,
        "created_by_current_user": false,
        "upvote_count": 2,
        "user_has_upvoted": false
    },
    {
        "id": 3,
        "parent": null,
        "created": "2015-01-03",
        "modified": "2015-01-03",
        "content": "@Hank Smith sed posuere interdum sem.\nQuisque ligula eros ullamcorper https://www.google.com/ quis, lacinia quis facilisis sed sapien. Mauris varius diam vitae arcu. Sed arcu lectus auctor vitae, consectetuer et venenatis eget.",
        "pings": [3],
        "creator": 1,
        "fullname": "You",
        "profile_picture_url": "img/common/commentAvatar.png",
        "created_by_admin": false,
        "created_by_current_user": true,
        "upvote_count": 2,
        "user_has_upvoted": true
    },
    {
        "id": 4,
        "parent": 3,
        "created": "2015-01-04",
        "modified": "2015-01-04",
        "file_url": "http://www.w3schools.com/html/mov_bbb.mp4",
        "file_mime_type": "video/mp4",
        "creator": 4,
        "fullname": "Pathma Raj",
        "profile_picture_url": "img/common/commentAvatar.png",
        "created_by_admin": false,
        "created_by_current_user": false,
        "upvote_count": 0,
        "user_has_upvoted": false
    },
    {
        "id": 5,
        "parent": 4,
        "created": "2015-01-05",
        "modified": "2015-01-05",
        "content": "Quisque ligula eros ullamcorper quis, lacinia quis facilisis sed sapien. Mauris varius diam vitae arcu. Sed arcu lectus auctor vitae, consectetuer et venenatis eget velit.",
        "pings": [],
        "creator": 3,
        "fullname": "Mohamed Ajmal",
        "profile_picture_url": "img/common/commentAvatar.png",
        "created_by_admin": false,
        "created_by_current_user": false,
        "upvote_count": 0,
        "user_has_upvoted": false
    },
    {
        "id": 6,
        "parent": 1,
        "created": "2015-01-06",
        "modified": "2015-01-06",
        "content": "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed posuere interdum sem. Quisque ligula eros ullamcorper quis, lacinia quis facilisis sed sapien. Mauris varius diam vitae arcu.",
        "pings": [],
        "creator": 2,
        "fullname": "Mohammed Ismail",
        "profile_picture_url": "img/common/commentAvatar.png",
        "created_by_admin": false,
        "created_by_current_user": false,
        "upvote_count": 1,
        "user_has_upvoted": false
    },
    {
        "id": 7,
        "parent": 1,
        "created": "2015-01-07",
        "modified": "2015-01-07",
        "content": "Sed posuere interdum sem. Quisque ligula eros ullamcorper quis, lacinia quis facilisis sed sapien. Mauris varius diam vitae arcu. Sed arcu lectus auctor vitae, consectetuer et venenatis eget velit.",
        "pings": [],
        "creator": 5,
        "fullname": "Administrator",
        "profile_picture_url": "img/common/commentAvatar.png",
        "created_by_admin": true,
        "created_by_current_user": false,
        "upvote_count": 0,
        "user_has_upvoted": false
    },
    {
        "id": 8,
        "parent": 6,
        "created": "2015-01-08",
        "modified": "2015-01-08",
        "content": "Sed posuere interdum sem. Quisque ligula eros ullamcorper quis, lacinia quis facilisis sed sapien. Mauris varius diam vitae arcu.",
        "pings": [],
        "creator": 1,
        "fullname": "You",
        "profile_picture_url": "img/common/commentAvatar.png",
        "created_by_admin": false,
        "created_by_current_user": true,
        "upvote_count": 0,
        "user_has_upvoted": false
    },
    {
        "id": 9,
        "parent": 8,
        "created": "2015-01-09",
        "modified": "2015-01-10",
        "content": "Quisque ligula eros ullamcorper quis, lacinia quis facilisis sed sapien. Mauris varius diam vitae arcu. Sed arcu lectus auctor vitae, consectetuer et venenatis eget velit.",
        "pings": [],
        "creator": 7,
        "fullname": "Maha anand",
        "profile_picture_url": "img/common/commentAvatar.png",
        "created_by_admin": false,
        "created_by_current_user": false,
        "upvote_count": 0,
        "user_has_upvoted": false
    },
    {
        "id": 10,
        "parent": 9,
        "created": "2015-01-10",
        "modified": "2015-01-10",
        "content": "Quisque ligula eros ullamcorper quis, lacinia quis facilisis sed sapien. Mauris varius diam vitae arcu. Sed arcu lectus auctor vitae, consectetuer et venenatis eget velit.",
        "pings": [],
        "creator": 1,
        "fullname": "You",
        "profile_picture_url": "img/common/commentAvatar.png",
        "created_by_admin": false,
        "created_by_current_user": true,
        "upvote_count": 0,
        "user_has_upvoted": false
    }
]

var usersArray = [
    {
        id: 1,
        fullname: "Current User",
        email: "current.user@gmail.com",
        profile_picture_url: "img/common/commentAvatar.png"
    },
    {
        id: 2,
        fullname: "Mohammed Ismail",
        email: "ismail@gmail.com",
        profile_picture_url: "img/common/commentAvatar.png"
    },
    {
        id: 3,
        fullname: "Mohamed Ajmal",
        email: "ajmal@gmail.com",
        profile_picture_url: "img/common/commentAvatar.png"
    },
    {
        id: 4,
        fullname: "Pathma Raj",
        email: "pathma@gmail.com",
        profile_picture_url: "img/common/commentAvatar.png"
    },
    {
        id: 5,
        fullname: "Administrator",
        email: "administrator@viima.com",
        profile_picture_url: "img/common/commentAvatar.png"
    },
    {
        id: 6,
        fullname: "Raj Kumar",
        email: "raj@gmail.com",
        profile_picture_url: "img/common/commentAvatar.png"
    },
    {
        id: 7,
        fullname: "Maha Anand",
        email: "anand@gmail.com",
        profile_picture_url: "img/common/commentAvatar.png"
    }
]