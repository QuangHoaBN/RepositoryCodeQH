/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

import java.util.Scanner;

/**
 *
 * @author ronna
 */
public class RSA {
    private int P,Q,E,N,phiN;

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
    }

    public int getPhiN() {
        return phiN;
    }

    public void setPhiN(int phiN) {
        this.phiN = phiN;
    }
    
    public int getP() {
        return P;
    }

    public void setP(int P) {
        this.P = P;
    }

    public int getQ() {
        return Q;
    }

    public void setQ(int Q) {
        this.Q = Q;
    }

    public int getE() {
        return E;
    }

    public void setE(int E) {
        this.E = E;
    }

    public RSA(int P, int Q, int E) {
        this.P = P;
        this.Q = Q;
        this.E = E;
    }
    public void Check(){
        if(P<2) System.out.println("P không phải là số nguyên tố!");
        else if(P>=2){
            for (int i = 2; i <P; i++) {
                if(P%i==0) System.out.println("P không phải là số nguyên tố!");
            }
        }
        if(Q<2) System.out.println("Q không phải là số nguyên tố!");
        else if(Q>=2){
            for (int j = 2; j <Q; j++) {
                if(Q%j==0) System.out.println("Q không phải là số nguyên tố!");
            }
        }
         N=P*Q;
        phiN=(P-1)*(Q-1);
        if(UCLN(E,phiN)!=1) System.out.println("P và ($N) không là số nguyên tố cùng nhau!");
    }
    public int UCLN(int a, int b){
        if(b==0) return a=1;
        return UCLN(a,a%b);
    }
    public void PubKey(){
        if(UCLN(E,phiN)==1) System.out.println("Khóa công khai: Kp = ("+E+"; "+N+")");
    }
    public void PrivKey(){
        int d=0,D;
        if(UCLN(E,phiN)==1){
            for(int i=1;i<=E;i++){
                D=(i*phiN+1)%E;
                if(D==0){
                  d=(i*phiN+1)/E;
                }
            } System.out.println("Khóa bí mật: Ks = ("+d+"; "+P+"; "+Q+")");
        }
    }
    public void Encrypt(){
        System.out.print("Nhập bản rõ: ");
        int M=new Scanner(System.in).nextInt();
        int mahoa=(int)(Math.pow(M, E))%N;
        System.out.println("Bãn mã: "+mahoa);
    }
    public static void main(String[] args) {
        RSA rsa=new RSA(11,47,3);
        rsa.Check();
        rsa.PubKey();
        rsa.PrivKey();
        rsa.Encrypt();
    }
    
}
