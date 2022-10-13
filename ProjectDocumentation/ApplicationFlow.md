## Application Flow  
### User Sign Up
1. User chooses sign up from the navigation menu page (available on all pages, unless the user is signed in already) or from link on login page.  
2. User fills out the sign up form and submits.  
3. Request goes to signUp servlet.
4. Servlet creates a user object and then creates user in the database.
5. Redirect to home page, with welcome message in nav menu for new user.

### User Sign In
1.	User chooses sign in from the navigation menu (available on all pages, unless the user is signed in already), or from not being logged in and clicking one of the following options:
      A.	‘Add Scale/Chord’ from the navigation menu
      B.	‘View My Scales/Chords’ from the navigation menu
      C.	The link to add a scale or chord on the keyResults page
2.	User enters username and password on form and submits.
3.	If user is authenticated, user object is added to the attribute map.  The server will handle allowing access to the Add and View pages. JDBCRealm used for authentication (users, usersroles, and roles table).
4.	If authentication fails, show error message/page.

### User Added Scales and Chords
1.	User gets to this jsp (userAddScalesChords jsp) from selecting the ‘Add a Scale or Chord’ option from the navigation menu, or from a link on keyResults jsp.
2.	User selects an option of scale or chord to add, providing a scale or chord name, a scale or chord description, and submits the form.
3.	A Servlet takes the form parameters and determines whether to create a Scale or Chord object.
4.	Servlet sends Scale or Chord object to Scale DAO or Chord DAO
5.	DAO adds scale or chord data to the DB.
6.	A confirmation message is sent from servlet and is displayed in the userAddScaleChords jsp.  The userAddScaleChords jsp is reset for more entries.

### View User Added Scales and Chords
1.	User gets to this jsp (viewUserScalesChords) by selecting the ‘View My Scales and Chords’ option from the navigation menu.
2.	The ViewUserScalesChords servlet calls the Scale DAO and Chord DAO
3.	The DAOs use selects to create Scale and Chord objects based on user.
4.	DAOs return lists of scale and chord criteria to ViewUserScalesChords servlet.
5.	Servlet forwards to viewUserScalesChords jsp putting the returned lists of user scale/chord data in the map.
6.	The viewUserScalesChords jsp displays the user scale and chord data from the map.

### Delete User Added Scales and Chords
1.	User must be on the (viewUserScalesChords) jsp and have one or more added scales/chords displayed
2.	User clicks delete button on a scale or chord displayed in the jsp.
3.	The ViewUserScalesChords servlet is called from the jsp.
4.	The servlet calls the Scale or Chord DAO with information about which of the user’s added scales or chords to delete.
5.	The appropriate DAO deletes the user scale or chord from the DB and does a new select on the user’s scales and chords, creating lists.
6.	The servlet puts the lists from the DAOs in the map.
7.	A confirmation message about the deletion is sent from servlet and displayed in the viewUserScaleChords jsp.

### View Scales, Chords, Songs by Key
1.	Option available to everyone (registered and non-registered users)
2.	User selects key from home page, passing key to GetKeyData servlet
3.	Get Servlet stores key in request/attribute map and uses the Key DAO to get the scales, chords, and songs for the key
4.	Key DAO returns lists of scales, chords, and songs to display
5.	GetKeyData servlet sends lists to displayKeyData jsp
