### RequireJs

RequireJS is a JavaScript file and module loader. It is optimized for in-browser use, but it can be used in other JavaScript environments, like Rhino and Node. Using a modular script loader like RequireJS will improve the speed and quality of your code.

* [RequireJs]( http://requirejs.org/)
* [Github]( https://github.com/requirejs/requirejs)


### **Implemented HATEOAS:**
* Get User by ID: 
```
{
  "id": 5,
  "fullname": "administrator@gmail.com",
  "email": "Administrator",
  "profile_picture_url": "img/common/commentAvatar.png",
  "links": [
    {
      "rel": "Self",
      "href": "http://localhost:8091/CommentRESTService/users/5"
    }
  ]
}

```

* Get Comment by ID:

```
{
  "id": 2,
  "parent": null,
  "created": "2017-03-28",
  "modified": "2017-03-28",
  "content": "Sed posuere interdum sem. Quisque ligula eros ullamcorper quis, lacinia quis facilisis sed sapien. Mauris varius diam vitae arcu.",
  "pings": null,
  "creator": 5,
  "fullname": "Administrator",
  "profile_picture_url": "img/common/commentAvatar.png",
  "created_by_admin": true,
  "created_by_current_user": false,
  "upvote_count": 2,
  "user_has_upvote": false,
  "links": [
    {
      "rel": "Self",
      "href": "http://localhost:8091/CommentRESTService/comments/2"
    }
  ]
}
```


SnapShot:

![Alt text](https://github.com/ikismail/Blog-CommentSection/blob/master/CommentFrontEnd/WebContent/img/commentSection.jpg)



License
-------
Latest Release: 2.3.3
Open source: new BSD or MIT licensed
web design by Andy Chung © 2011-2017
