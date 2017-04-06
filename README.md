### RequireJs

RequireJS is a JavaScript file and module loader. It is optimized for in-browser use, but it can be used in other JavaScript environments, like Rhino and Node. Using a modular script loader like RequireJS will improve the speed and quality of your code.

* [RequireJs]( http://requirejs.org/)
* [Github]( https://github.com/requirejs/requirejs)


### **Implemented HATEOAS:**
* Get User by ID: 
```
{
  "id": 5,
  "user": {
    "fullname": "Administrator",
    "email": "administrator@gmail.com",
    "self": {
      "href": "/rest/user/5"
    }
  },
  "avatar": {
    "profile_picture_url": "img/common/commentAvatar.png",
    "self": {
      "href": "/image/Administrator/5"
    }
  }
}

```

* Get Comment by ID:

```
{
  "id": 2,
  "created_by_current_user": false,
  "created_by_admin": true,
  "user_has_upvoted": false,
  "parent": null,
  "author": {
    "creator": 5,
    "fullname": "Administrator",
    "self": {
      "href": "/profile/Administrator/5"
    }
  },
  "message": {
    "content": "Sed posuere interdum sem. Quisque ligula eros ullamcorper quis, lacinia quis facilisis sed sapien. Mauris varius diam vitae arcu.",
    "date": {
      "created": "\"2017-03-28",
      "modified": "2017-03-28"
    },
    "upvote_count": 2,
    "pings": null
  },
  "avatar": {
    "profile_picture_url": "img/common/commentAvatar.png",
    "self": {
      "href": "Administrator/images/5"
    }
  },
  "self": {
    "href": "/rest/comment/2"
  }
}
```


SnapShot:

![Alt text](https://github.com/ikismail/Blog-CommentSection/blob/master/CommentFrontEnd/WebContent/img/commentSection.jpg)



License
-------
Latest Release: 2.3.3
Open source: new BSD or MIT licensed
web design by Andy Chung © 2011-2017
