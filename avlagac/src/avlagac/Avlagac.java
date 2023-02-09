   
package avlagac;
class dugum{
    int icerik,yukseklik;
    dugum sol,sag;
    public dugum (int icerik){
        this.icerik=icerik;
        yukseklik=1;
        sol=null;
        sag=null;
    }
    
}

public class Avlagac {
dugum kok;
int yukseklik(dugum N){
    if(N==null) return 0;
    else return N.yukseklik;
}
int maks(int a, int b){
    if(a>b) return a;
    else return b;
}
dugum sagaDondur(dugum y){
 dugum x=y.sol;
 dugum T2=x.sag;
 x.sag=y;
 y.sol=T2;
 y.yukseklik=maks(yukseklik(y.sol),yukseklik(y.sag))+1;
 x.yukseklik=maks(yukseklik(x.sol),yukseklik(x.sag))+1;
 return x;
}
dugum solaDondur(dugum x){   
    dugum y=x.sag;
    dugum T2=y.sol;
    y.sol=x;
    x.sag=T2;
    x.yukseklik=maks(yukseklik(x.sol),yukseklik(x.sag))+1; //yüksekliği kullanıyor ki denge faktörüe bakabilmek için
    y.yukseklik=maks(yukseklik(y.sol),yukseklik(y.sag))+1;
    return y;
}
    
int dengef(dugum N)
{
    if(N==null) return 0;
    else return yukseklik(N.sol)-yukseklik(N.sag);// denge faktörü yükseklik farklarıdır yani
    
}
dugum ekle(dugum d,int yeni){
    if(d==null)
        return (new dugum(yeni));
    if(yeni<d.icerik)
        d.sol=ekle(d.sol,yeni);
    else if(yeni>d.icerik)
        d.sag=ekle(d.sag,yeni);
    else return d;
    d.yukseklik=1+maks(yukseklik(d.sol), yukseklik(d.sag));
    int denge= dengef(d);
    //sol-sol
    if(denge>1 && yeni<d.sol.icerik)
        return sagaDondur(d);
    //sag-sag
    if(denge<-1 && yeni>d.sag.icerik) //-2 olmuş yani 
        return solaDondur(d);
    //sol-sag
    if(denge>1 && yeni>d.sol.icerik){
        d.sol=solaDondur(d.sol);
        return sagaDondur(d);
        
    }
    //sag-sol
    if(denge<-1 && yeni<d.sag.icerik){
        d.sag=sagaDondur(d.sag);
        return solaDondur(d);
        
    }
    return d;
}
    
    void inOrder(dugum d){
    if(d!=null){
        inOrder(d.sol);
        System.out.println(d.icerik+"");
        inOrder(d.sag);
    }
}
    void maksimum (){
        dugum d=kok;
        if(d==null) System.out.println("agac bos");
        int say=0;
        while (d.sag!=null){
            d=d.sag;
            say++;
        }
        System.out.println("en buyuk : " +d.icerik+" "+say+"adımda bulundu");   
    }
 public static void main(String[] args) {
    }}
//avl ekleme sınav uygukama kısmını falan da