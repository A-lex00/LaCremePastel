package com.ispwproject.lecremepastel.other;

import com.ispwproject.lecremepastel.engineeringclasses.singleton.Configurations;

import java.io.*;
import java.nio.file.Path;

public class JsonDaoUtils {

    public Path checkUserdataDir(String username){
        //Dir creation if not existent
        String userdataPath = Configurations.getInstance().getProperty("PATH_USERDATA");
        Path userDir = Path.of(userdataPath,username);
        userDir.toFile().mkdirs();
        return userDir;
    }

    public void writeUserFile(Path userFile, String content) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(userFile.toFile()))){
            bw.write(content);
            bw.flush();
        }
    }

    public String loadJsonString(String username) throws IOException {
        String userdataPath = Configurations.getInstance().getProperty("PATH_USERDATA");
        File userdata = Path.of(userdataPath,username).toFile();
        String[] ls = userdata.list();
        if(ls != null){
            try (BufferedReader br = new BufferedReader(new FileReader(Path.of(userdataPath, username, "userInfo.json").toFile()))) {
                return br.readLine();
            }
        }else{
            throw new IOException("JsonDaoUtils: IO Error occourred");
        }
    }

}
