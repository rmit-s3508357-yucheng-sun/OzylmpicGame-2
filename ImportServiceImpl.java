/*
 * @author YI YANG s3520987
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/14 0014.
 */
public class ImportServiceImpl implements ImportService {
    @Override
    public List<Participant> importParticipant(String filePath) {
        List<Participant> rtnList=new ArrayList<Participant>();
        File file=new File(filePath);
        if(!file.exists()){
            return null;
        }
        BufferedReader bf=null;
        String line="";
        try{
            bf=new BufferedReader(new FileReader(file));
            while((line=bf.readLine())!=null){
                boolean isDuplicated=false;
                boolean isIncorrect=false;
                String[] prop=line.trim().split(",");
                for(String s:prop){
                    if(s==null&&"".equals(s)){
                        isIncorrect=true;
                        break;
                    }
                }
                if(isIncorrect){
                    continue;
                }
                String id=prop[0];
                String type=prop[1];
                String name=prop[2];
                int age=Integer.parseInt(prop[3]);
                String state=prop[4];
                for(Participant p:rtnList){
                    if(id.equals(p.getID())){
                        isDuplicated=true;
                        break;
                    }
                }
                if(isDuplicated){
                    continue;
                }
                Participant p=null;
                switch(type){
                    case "officer": p=new Official(id,name,age,state);break;
                    case "sprinter": p=new Sprinter(id,name,age,state);break;
                    case "swimmer": p=new Swimmer(id,name,age,state);break;
                    case "cyclist":p=new Cyclist(id,name,age,state);break;
                    case "super":p=new SuperAthlete(id,name,age,state);break;
                }
                rtnList.add(p);
            }
            return rtnList;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (bf != null) {
                    bf.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
