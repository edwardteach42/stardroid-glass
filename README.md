stardroid-glass
===============

Google Sky Map port for Google Glass XE

Since Sky Map is open source, I got curious as to how well it would run on Glass, which led me to where we are now.  Initially all you could do was look around but that has since changed.

Features Working:
 *   Terms and Conditions
 *   All sensors work perfectly
 *   Zoom (Swipe slowly from left to right to zoom in or out)
 *   Tap once to open up the options.  This will give you the ability to enter the preferences and edit the layers etc.
 *   The Day/Night toggle is working
 *   Swipe down is the "back button"
 *   Added confirm on exit as I found I kept accidentally closing the app out.

Features Not Yet Working:
 *   Search (Need to figure out how to implement voice search)
 *   TimeWarp (The popup needs to be reconfigured for glass and then that feature should be usable)
 *   Gallery (This is a little used feature so I am not worrying too much about it)
 
Features Removed:
 *   Removed the toggle for manual mode.  Kind of pointless on Glass, right?
 *   Removed layers widget as there was no logical way to control this from glass.
 *   Removed the zoom controllers from the screen as they were useless too.
 
## Installation Instructions:
Please note that [Launchy](https://github.com/kaze0/launchy) is required for this to work.  This works perfectly for me, but I cannot be held responsible if you brick your device.  If you do not know what you are doing then I recommend that you have an experienced friend install it for you or take some time and learn to do it yourself. :)
 1.   Compile the APK using your favorite IDE
 2.   Make sure that you have put your Glass into Debug Mode
 3.   Plug your Glass in and push the APK using adb with 'adb install stardroid-glass.apk'   