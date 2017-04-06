import java.util.ArrayList;

/*the Interface of the data,which will be used in the simulation*/
public class Generate {
	
	/*create 6 games,in every game there serveal athlete and a referee*/
	public ArrayList<Game> generateGames(){
		/*generate game1*/
		Game game1 = new SwimGame(1);
		game1.setType("Swimming");
		Athlete athleteSwim00 = new Swimmer("A0000","Anjd01",23,"WA");
		Athlete athleteSwim01 = new Swimmer("A0001","Bns02",32,"VIC");
		Athlete athleteSwim02 = new Swimmer("A0002","Cas03",24,"QLD");
		Athlete athleteSwim03 = new Swimmer("A0003","Dsan04",29,"WA");
		Athlete athleteSwim04 = new Swimmer("A0004","Ems05",25,"AU");
		Athlete athleteSwim05 = new Swimmer("A0005","Fska06",29,"VIC");
		Athlete athleteSpuer00 = new SuperAthlete("A0006","Gsmd07",19,"NEW");
		Athlete athleteSpuer01 = new SuperAthlete("A0007","Hnsb08",19,"NEW");
		Official official00 = new Official("o0000","#dsa",28,"VIC");
		game1.getAthletesOfGame().add(athleteSpuer01);
		game1.getAthletesOfGame().add(athleteSpuer00);
		game1.getAthletesOfGame().add(athleteSwim05);
		game1.getAthletesOfGame().add(athleteSwim04);
		game1.getAthletesOfGame().add(athleteSwim03);
		game1.getAthletesOfGame().add(athleteSwim02);
		game1.getAthletesOfGame().add(athleteSwim01);
		game1.getAthletesOfGame().add(athleteSwim00);
		game1.setReferee(official00);
		
		
		/*generate game1*/
		Game game2 = new SwimGame(2);
		game2.setType("Swimming");
		Athlete athleteSwim06 = new Swimmer("A0008","Lnjd09",22,"WA");
		Athlete athleteSwim07 = new Swimmer("A0009","Mns10",21,"VIC");
		Athlete athleteSwim08 = new Swimmer("A0010","Nas11",19,"NEW");
		Athlete athleteSwim09 = new Swimmer("A0011","Osan12",29,"WA");
		Athlete athleteSwim10 = new Swimmer("A0012","Pms13",18,"AU");
		Athlete athleteSwim11 = new Swimmer("A0013","Qska14",39,"QLD");
		Athlete athleteSpuer02 = new SuperAthlete("A0014","Rsmd15",19,"QLD");
		Athlete athleteSpuer03 = new SuperAthlete("A0015","Snsb16",19,"AU");
		Official official01 = new Official("O0001","#reqw",21,"QLD");
		game2.getAthletesOfGame().add(athleteSpuer03);
		game2.getAthletesOfGame().add(athleteSpuer02);
		game2.getAthletesOfGame().add(athleteSwim06);
		game2.getAthletesOfGame().add(athleteSwim07);
		game2.getAthletesOfGame().add(athleteSwim08);
		game2.getAthletesOfGame().add(athleteSwim09);
		game2.getAthletesOfGame().add(athleteSwim10);
		game2.getAthletesOfGame().add(athleteSwim11);
		game2.setReferee(official01);
		
		
		/*generate game3*/
		Game game3 = new RunGame(3);
		game3.setType("Running");
		Athlete athleteRun00 = new Sprinter("A0016","Tdmm17",22,"WA");
		Athlete athleteRun01 = new Sprinter("A0017","Unds18",29,"VIC");
		Athlete athleteRun02 = new Sprinter("0018","Vsd19",39,"VIC");
		Athlete athleteRun03 = new Sprinter("A0019","Wdds20",19,"WA");
		Athlete athleteRun04 = new Sprinter("A0020","Xdm21",19,"WA");
		Athlete athleteSpuer04 = new SuperAthlete("A0021","Zsdm22",39,"QLD");
		Athlete athleteSpuer05 = new SuperAthlete("A0022","Ahsj23",25,"WA");
		Official official02 = new Official("O0002","#jkb",34,"AU");
		game3.getAthletesOfGame().add(athleteSpuer04);
		game3.getAthletesOfGame().add(athleteSpuer05);
		game3.getAthletesOfGame().add(athleteRun04);
		game3.getAthletesOfGame().add(athleteRun03);
		game3.getAthletesOfGame().add(athleteRun02);
		game3.getAthletesOfGame().add(athleteRun01);
		game3.getAthletesOfGame().add(athleteRun00);
		game3.setReferee(official02);
		
		
		/*generate game4*/
		Game game4 = new RunGame(4);
		game4.setType("Running");
		Athlete athleteRun05 = new Sprinter("A0023","Bvm24",19,"WA");
		Athlete athleteRun06 = new Sprinter("A0024","Coiu25",19,"VIC");
		Athlete athleteRun07 = new Sprinter("A0025","Ddb26",19,"VIC");
		Athlete athleteRun08 = new Sprinter("A0026","Ebzv27",19,"NEW");
		Athlete athleteRun09 = new Sprinter("A0027","Fqwn28",19,"QLD");
		Athlete athleteSpuer06 = new SuperAthlete("A0028","Gwv29",19,"WA");
		Official official03 = new Official("O0003","#nbdb",19,"WA");
		game4.getAthletesOfGame().add(athleteSpuer06);
		game4.getAthletesOfGame().add(athleteRun09);
		game4.getAthletesOfGame().add(athleteRun08);
		game4.getAthletesOfGame().add(athleteRun07);
		game4.getAthletesOfGame().add(athleteRun06);
		game4.getAthletesOfGame().add(athleteRun05);
		game4.setReferee(official03);
		
		
		
		/*generate game5*/
		Game game5 = new ClclyGame(5);
		game5.setType("Cycling");
		Athlete athleteCycly00 = new Cyclist("A0030","Hidb30",22,"VIC");
		Athlete athleteCycly01 = new Cyclist("A0031","Inds31",28,"VIC");
		Athlete athleteCycly02 = new Cyclist("A0032","Jdn32",29,"NEW");
		Athlete athleteCycly03 = new Cyclist("A0033","Kdnsh33",20,"NEW");
		Athlete athleteCycly04 = new Cyclist("A0034","Lds34",18,"QLD");
		Athlete athleteCycly05 = new Cyclist("A0035","Mdbs35",17,"VIC");
		Athlete athleteSuper08 = new SuperAthlete("A0036","Ndhs36",16,"WA");
		Athlete athleteSuper09 = new SuperAthlete("A0037","Ods37",15,"AU");
		Official official04 = new Official("o0004","#YSDY",39,"WA");
		game5.getAthletesOfGame().add(athleteSuper08);
		game5.getAthletesOfGame().add(athleteSuper09);
		game5.getAthletesOfGame().add(athleteCycly05);
		game5.getAthletesOfGame().add(athleteCycly04);
		game5.getAthletesOfGame().add(athleteCycly03);
		game5.getAthletesOfGame().add(athleteCycly02);
		game5.getAthletesOfGame().add(athleteCycly01);
		game5.getAthletesOfGame().add(athleteCycly00);
		game5.setReferee(official04);
		
		
		
		/*generate game6*/
		Game game6 = new ClclyGame(6);
		game6.setType("Cycling");
		Athlete athleteCycly06 = new Cyclist("A0038","PDJ38",22,"VIC");
		Athlete athleteCycly07 = new Cyclist("A0039","QDS39",25,"QLD");
		Athlete athleteCycly08 = new Cyclist("A0040","RDSJ40",29,"WA");
		Athlete athleteCycly09 = new Cyclist("A0041","SDWU41",19,"NEW");
		Athlete athleteCycly10 = new Cyclist("A0042","UJHN42",19,"AU");
		Official official05 = new Official("o0005","#psjdn",46,"WA");
		game6.getAthletesOfGame().add(athleteCycly10);
		game6.getAthletesOfGame().add(athleteCycly09);
		game6.getAthletesOfGame().add(athleteCycly08);
		game6.getAthletesOfGame().add(athleteCycly07);
		game6.getAthletesOfGame().add(athleteCycly06);
		game6.getAthletesOfGame().add(athleteSpuer03);
		game6.getAthletesOfGame().add(athleteSpuer02);
		game6.setReferee(official05);
	
		/*define a ArrayList to stire all the games*/
		ArrayList<Game> games = new ArrayList<Game>();
		games.add(game1);
		games.add(game2);
		games.add(game3);
		games.add(game4);
		games.add(game5);
		games.add(game6);
		
		return games;
	}
	
	public void displayGames(){
		ArrayList<Game> games = new ArrayList<Game>();
		games = generateGames();
		for(Game g : games){
			System.out.println(g.getID());
			System.out.println(g.getReferee());
			for(Athlete a : g.getAthletesOfGame()){
				System.out.println(a);
			}
			
		}
	}
}
