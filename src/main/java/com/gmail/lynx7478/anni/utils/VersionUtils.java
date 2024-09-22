package com.gmail.lynx7478.anni.utils;

import org.bukkit.Bukkit;

public class VersionUtils
{
    public static String getVersion()
    {
        String packageName = Bukkit.getServer().getClass().getPackage().getName();
        return packageName.substring(packageName.lastIndexOf(".") + 1);
    }
    
    public static boolean is1_9(){
        String packageName = Bukkit.getServer().getClass().getPackage().getName();
        packageName.substring(packageName.lastIndexOf(".") + 1);
        if(packageName.contains("v1_9"))
        	return true;
        else
        	return false;
    }
    
    public static boolean above9()
    {
    	String packageName = Bukkit.getServer().getClass().getPackage().getName();
    	packageName.substring(packageName.lastIndexOf(".") + 1);
    	if(packageName.contains("v1_9") || packageName.contains("v1_10") || packageName.contains("v1_11")
    			|| packageName.contains("v1_12") || packageName.contains("v1_13") || packageName.contains("v1_14")
    			|| packageName.contains("v1_15") || packageName.contains("v1_16") || packageName.contains("v1_17") 
    			|| packageName.contains("v1_18") || packageName.contains("v1_19") || packageName.contains("v1_20"))
    		return true;
    	else
    		return false;
    }
    
    public static boolean above13()
    {
    	String packageName = Bukkit.getServer().getClass().getPackage().getName();
    	packageName.substring(packageName.lastIndexOf(".") + 1);
    	if(packageName.contains("v_13") || packageName.contains("v1_14") || packageName.contains("v1_15") || packageName.contains("v1_16")
    			|| packageName.contains("v1_17") 
    			|| packageName.contains("v1_18") || packageName.contains("v1_19") || packageName.contains("v1_20"))
    		return true;
    	else
    		return false;
    }
}
