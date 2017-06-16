/**
 * Created by yjw on 17-4-25.
 */
public class projecteuler {
    public static void main(String[] args){
        p3();
    }

    public static void p1(){

    }

    public static void p2(){
        int num[] =new int[10000000];
        num[0]=1;num[1]=2;
        int sum=0,i=2;
        sum=num[i-1]+num[i-2];
        long total=0;
        while(sum<4000000){
            if(sum%2==0){
                total=total+sum;
            }
            num[i++]=sum;
            sum=num[i-1]+num[i-2];
        }
        System.out.println(total);
    }

    public static void p3(){
        long start=System.currentTimeMillis();
       int primes[]=new int[10000000];
        boolean a[]=new boolean[10000000];
        int loc=0;
       /* for(long num=2;num<=60000000000L;num++){
            boolean p=true;
            for(long test=2;test*test<=num;test++){
                if(num%test==0){
                    p=false;
                }
            }
            if(p)
                primes[loc++]=num;
        }*/
        int num=0;
        for(int i=2;i<10000;i++){
            if(!a[i])
                primes[num++]=i;
            for(int j=0;(j<num&&i*primes[j]<10000);j++){
                a[i*primes[j]]=true;
                if(i%primes[j]==0)
                    break;
            }
        }

        System.out.println("total prime[] time:"+(System.currentTimeMillis()-start)/1000);
    }
}
