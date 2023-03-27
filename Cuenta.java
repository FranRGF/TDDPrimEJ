public class Cuenta {
    private double saldo;
    public Cuenta(){
        saldo = 0;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo(){
        return saldo;
    }
    public boolean esCantidadValida(double cantidad){
        if(cantidad <0 || cantidad >6000) {
            return false;
        }
        return true;
    }
    public void ingresar(double cantidad){
        if(!esCantidadValida(cantidad)) {
            saldo = 0;
        }
        else {
            saldo += cantidad;
        }
    }
    public void retirar (double cantidad){
        if (cantidad > saldo || !esCantidadValida(cantidad)){
            saldo = getSaldo();
        } else {
            saldo -= cantidad;
        }
    }
    public void hacerTrans (double cantidad, Cuenta cuenta){
        if (cantidad < 0 || cantidad > 3000){
            return;
        } else {
            saldo -= cantidad;
            cuenta.ingresar(cantidad);
        }
    }
}
