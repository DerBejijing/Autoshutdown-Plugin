# Autoshutdown-Plugin
A minecraft spigot / paper MC / etc. Plugin to automate Server shutdowns


**This is a minecraft Plugin designed for Papermc and Spigot servers to automate shuting down the server**  
The repository includes the `Autoshutdown.jar` you can use like any other Plugin, and the sourcecode. To modify it you will need to setup a workspace for making Plugins, which you can learn elsewhere.  

**VERY VERY IMPORTANT**  
By default the shutdown is disabled!! You will have to either use `/enable` or the config file to activate it!  

**Config file**  
When the plugin is loaded for the first time, the config file is created in `/plugins/Autoshutdown`. There you can set the shutdown time, when warnings should be displayed, if the physical server should also be shut down, and more. Let's break down all the settings:  
```
#Info: all dates are written in the format HH:mm:ss

#wether everyone knows when the shutdown is scheduled
#affects the join message AND the /getshutdown command
publicShutdown: true

#wether the shutdown is enabled
active: false

#time for the server to shutdown
shutdown: "21:10:00"

#warning times
shutdownWarnings:
   - 5
   - 10
   - 30
   - 60
   - 300
   - 600
   - 1800

#Wether the physical computer should shutdown after the server did
#WARNING: on Linux and MAC this is a quite brutal shutdown (shutdown -h), so make sure there is no unsafed data that wouldn't survive a shutdown
physicalShutdown: false

#specify a physical shutdown delay (minutes)
physicalShutdownDelay: 1

#message to be displayed if the command executor does not have the required permissions
noPermission: "Foolish! You do not have permission to execute this command"

#Permission to abort the shutdown
permissionAbort: "autoshutdown.abort"

#Permission to enable the shutdown
permissionEnable: "autoshutdown.enable"

#Permission to reschedule the shutdown
permissionEnable: "autoshutdown.reschedule"
```
One more word to Platforms. It is tested on multiple Linux distributions and macOS. Technically it should work on windows 10, but there is really no reason to run a minecraft server on windows lmao. Also note that the physical shutdown does not take care of **any** unsafed data as already mentioned. For the physicalShutdownDelay rather use a bit more than too less.  

**Commands**  
The plugin includes some commands that can be used to modify some of the settings without using the config file.  
`/abort`: Disables the shutdown  
`/enable`: Enables the shutdown  
`/getshutdown`: Shows when the shutdown is scheduled  
`/reschedule <time>`: sets the shutdown to the specified time. There is no check for the input, just don't enter garbage :)  

**What you can to do**  
You are allowed to use this Plugin, modify the sourcecode and include it in other Programms/Plugins/etc, as long as I am always mentioned as the developer.  

**What you cannot do**  
You are not allowed to use this, for whatever reason, for commercial purposes.  

**Updates and bugfixes**  
I am always working on finding and eliminating bugs. So if you find one, feel free to cantact me. Another problem is that for some reason the comments disappear after the config is saved... I am still working on that.  
