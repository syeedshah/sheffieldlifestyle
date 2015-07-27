function fbc_permissions() {
  $.ajax({
    dataType: "json",
    type: "GET",
    url: "/ajax/fbc_check_perms",
    success: function(result) {
      if(result[0]) {
        FB.Connect.showPermissionDialog(result[0],
          function(x) { fbc_on_login(); });
        } else {
          fbc_on_login();
        }
      }
  });
} 

function fbc_post_login() {
  $.ajax({
    dataType: "json",
    type: "GET",
    url: "/ajax/fbc_post_login",
    success: function(result) {
      var user_box = $("#user-login");
      // add in some XFBML. note that we set useyou=false so it doesn't display "you" 
      user_box.html("<span>" 
      + "<fb:profile-pic uid=loggedinuser facebook-logo=true></fb:profile-pic>" 
      + "Welcome, <fb:name uid=loggedinuser useyou=false></fb:name>. You are signed in with your Facebook account." 
      + "</span>"
      + "<p><a href=\"#\" onclick=\"fbc_logout();\" title=\"Logout\"><strong>logout</strong></a></p>"); 
      // because this is XFBML, we need to tell Facebook to re-process the document
      FB.XFBML.Host.parseDomTree(); 
    }
  });
}

function fbc_on_login() {
  // call ajax function to check if this is user is already registered
  $.ajax({
    dataType: "json",
    type: "GET",
    url: "/ajax/fbc_get_action",
    success: function(result) {
      if(result[0] == 1) {
        // already connected reload page
        window.location = '/';
      } else {
        // new user, show registration form
        window.location = '/register';
      }
    }
  });
}

function fbc_logout() {
  $.ajax({
    dataType: "json",
    type: "GET",
    url: "/ajax/logout",
    success: function(result) {
     if(result[0] == 1) {
      FB.Connect.logoutAndRedirect('/index.php');
     }
     //window.location = '/';
    }
  });
}
