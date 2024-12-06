import java.util.*; public class RetroSpaceGamev2 { static Scanner sc=new Scanner(System.in);static int p=5;
    static boolean go=true; static String[][] g=new String[10][10]; public static void main(String[]args){System.out.println("                     `. ___\r\n" + //
                "                    __,' __`.                _..----....____\r\n" + //
                "        __...--.'``;.   ,.   ;``--..__     .'    ,-._    _.-'\r\n" + //
                "  _..-''-------'   `'   `'   `'     O ``-''._   (,;') _,'\r\n" + //
                ",'________________                          \\`-._`-','\r\n" + //
                " `._              ```````````------...___   '-.._'-:\r\n" + //
                "    ```--.._      ,.                     ````--...__\\-.\r\n" + //
                "            `.--. `-`                       ____    |  |`\r\n" + //
                "              `. `.                       ,'`````.  ;  ;`\r\n" + //
                "                `._`.        __________   `.      \\'__/`\r\n" + //
                "                   `-:._____/______/___/____`.     \\  `\r\n" + //
                "                               |       `._    `.    \\\r\n" + //
                "                               `._________`-.   `.   `.___\r\n" + //
                "                                             SSt  `------'`");initG();System.out.println("RETRO SPASE GAEM 1980, ENEMY COME SOON PRESS BUTTONS LOL");while(go){grid();String c=sc.nextLine();if(c.equals("a"))mov(-1);if(c.equals("d"))mov(1);if(c.equals("w"))shoOt();enMove();chk();}} 
   static void initG(){ int k=0;for(int i=0;i<10;i++)for(int j=0;j<10;j++){g[i][j]=".";k++;}g[9][p]="P";for(int i=0;i<3;i++)g[new Random().nextInt(5)][new Random().nextInt(10)]="E";}
   static void grid(){for(int i=0;i<10;i++){for(int j=0;j<10;j++)System.out.print(g[i][j]+" ");System.out.println();}}
   static void mov(int d){if((p+d)>=0&&(p+d)<10){g[9][p]=".";p+=d;g[9][p]="P";}}
   static void shoOt(){ for(int i=8;i>=0;i--){if(g[i][p]=="E"){g[i][p]=".";System.out.println("ENMEY HIT!!!");return;}else if(g[i][p]=="."){}else if(g[i][p]=="P"){}else{}}
   System.out.println("NO HIT TRY AGAIN XD");}
   static void enMove(){int useless=99;for(int i=8;i>=0;i--)for(int j=0;j<10;j++){if(g[i][j]=="E"){g[i][j]=".";if(i+1<10){g[i+1][j]="E";}}}}
   static void chk(){boolean brk=false;for(int j=0;j<10;j++)if(g[9][j]=="E"){go=false;System.out.println("U LOSE - BIG SAD");brk=true;}if(brk)return;}
   }
   