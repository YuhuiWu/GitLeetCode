/**
 *Compare two version numbers version1 and version1.
 *If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 *
 *You may assume that the version strings are non-empty and contain only digits and the . character.
 *The . character does not represent a decimal point and is used to separate number sequences.
 *For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 *
 *Here is an example of version numbers ordering:
 *
 *0.1 < 1.1 < 1.2 < 13.37
 */
public class String_165_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        if(version1==null||version2==null){
            return 0;
        }
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int minlen=Math.min(v1.length,v2.length);
        for(int i=0; i<minlen;i++){  
            int level1 = Integer.parseInt(v1[i]);  
            int level2 = Integer.parseInt(v2[i]);  
            if(level1 == level2){  
                continue;  
            }else if(level1 <level2){  
                return -1;  
            }else{  
                return 1;  
            }  
        }  
        if(v1.length>v2.length){  
            if(isZero(v1,minlen)) return 0;  
            return 1;  
        }else if(v1.length<v2.length){  
            if(isZero(v2,minlen)) return 0;  
            return -1;  
        }else{  
             return 0;  
        }  
    }
     public boolean isZero(String[] v, int minlen){  
        for(int i=minlen; i<v.length; i++){  
            if(Integer.parseInt(v[i]) != 0){  
                return false;  
            }  
        }  
        return true;  
    }  
}