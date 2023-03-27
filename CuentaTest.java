import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CuentaTest {
    @BeforeAll
    static void primeroqueNada(){
        System.out.println("Manu ponme un Five");
    }
    //TESTS INGRESOS
    @Test
    void testsDeIngresosA(){
        System.out.println("TESTS DE INGRESOS: ");
    }
    @Test
    void testAlCrearCuentaElSaldoEsCero(){
        Cuenta cuentaTest = new Cuenta();
        assertEquals(0,cuentaTest.getSaldo());
    }
    @Test
    void testAlIngresar100EnCuentaVaciaElSaldoEs100(){
        //Arrange (set up)
        Cuenta cuentaTest = new Cuenta();
        //Act
        cuentaTest.ingresar(100);
        //Assert
        assertEquals(100,cuentaTest.getSaldo());
    }
    @Test
    void testAlIngresar3000EnCuentaVaciaElSaldoEs3000(){
        //Arrange (set up)
        Cuenta cuentaTest = new Cuenta();
        //Act
        cuentaTest.ingresar(3000);
        //Assert
        assertEquals(3000,cuentaTest.getSaldo());
    }
    @Test
    void testAlIngresar3000EnCuentaCon100ElSaldoEs3100(){
        //Arrange (set up)
        Cuenta cuentaTest = new Cuenta();
        cuentaTest.ingresar(100);
        //Act
        cuentaTest.ingresar(3000);
        //Assert
        assertEquals(3100,cuentaTest.getSaldo());
    }
    @Test
    void testNoSePuedeIngresarCAntidadNegativa() {
        //Arrange (set up)
        Cuenta cuentaTest = new Cuenta();
        //Act
        cuentaTest.ingresar(-100);
        //Assert
        assertEquals(0,cuentaTest.getSaldo());
    }
    @Test
    void IngresoCantidad2Decimales(){
        Cuenta cuentaTest = new Cuenta();
        cuentaTest.ingresar(100.45);
        assertEquals(100.45,cuentaTest.getSaldo());
    }
    @Test
    void testIngresoMaximoEsDe6000(){
        //Arrange (set up)
        Cuenta cuentaTest = new Cuenta();
        //Act
        cuentaTest.ingresar(6000);
        //Assert
        assertEquals(6000,cuentaTest.getSaldo());
    }
    @Test
    void testIngresoMasDe6000NoEsValido(){
        //Arrange (set up)
        Cuenta cuentaTest = new Cuenta();
        //Act
        cuentaTest.ingresar(6000.01);
        //Assert
        assertEquals(0,cuentaTest.getSaldo());
    }

    // TESTS RETIRADA
    @Test
    void testsDeRetirosB(){
        System.out.println("TESTS DE RETIROS: ");
    }
    @Test
    void alRetirar100EnCuentaCon500ElSaldoEs400(){
        //Arrange (set up)
        Cuenta cuentaTest = new Cuenta();
        cuentaTest.ingresar(500);
        //Act
        cuentaTest.retirar(100);
        //Assert
        assertEquals(400,cuentaTest.getSaldo());
    }
    @Test
    void siRetiro500enCuentaCon200noOcurreNadaYelSaldoSigueSiendo200(){
        //Arrange (set up)
        Cuenta cuentaTest = new Cuenta();
        cuentaTest.ingresar(200);
        //Act
        cuentaTest.retirar(500);
        //Assert
        assertEquals(200,cuentaTest.getSaldo());
    }
    @Test
    void siRetiroMenos100enCuentaCon500noOcurreNadaYelSaldoSigueSiendo500(){
        //Arrange (set up)
        Cuenta cuentaTest = new Cuenta();
        cuentaTest.ingresar(500);
        //Act
        cuentaTest.retirar(-100);
        //Assert
        assertEquals(500,cuentaTest.getSaldo());
    }
    @Test
    void alRetirar100con45enCuentaCon500elSaldoes399con55O(){
        //Arrange (set up)
        Cuenta cuentaTest = new Cuenta();
        cuentaTest.ingresar(500);
        //Act
        cuentaTest.retirar(100.45);
        //Assert
        assertEquals(399.55,cuentaTest.getSaldo());
    }
    @Test
    void SiRetiro6000enUnaCuentaCon7000elSaldoesde1000(){
        //Arrange (set up)
        Cuenta cuentaTest = new Cuenta();
        cuentaTest.ingresar(6000);
        cuentaTest.ingresar(1000);
        //Act
        cuentaTest.retirar(6000);
        //Assert
        assertEquals(1000,cuentaTest.getSaldo());
    }
    @Test
    void SiRetiro6000con01enUnaCuentaCon7000elSaldoesde7000(){
        //Arrange (set up)
        Cuenta cuentaTest = new Cuenta();
        cuentaTest.ingresar(6000);
        cuentaTest.ingresar(1000);
        //Act
        cuentaTest.retirar(6000.01);
        //Assert
        assertEquals(7000,cuentaTest.getSaldo());
    }

    // TESTS TRANSFERENCIAS
    @Test
    void testsDeTransferenciasC(){
        System.out.println("TESTS DE TRANSFERENCIAS: ");
    }
    @Test
    void TransferenciaDe100DesdeUnaCuentaCon500aUnaCon50enlaPrimeraCuentaElSaldoSeQuedaraEn400yEnLaSegundaSeQuedaraEn150(){
        //Arrange (set up)
        Cuenta cuentaTest = new Cuenta();
        Cuenta cuentaTestTrans = new Cuenta();
        cuentaTestTrans.ingresar(500);
        cuentaTest.ingresar(50);
        //Act
        cuentaTestTrans.hacerTrans(100, cuentaTest);
        //Assert
        assertEquals(150,cuentaTest.getSaldo());
        assertEquals(400,cuentaTestTrans.getSaldo());
    }
    @Test
    void TransDeMenos100desdeUnaCuentaCon500aUnaCon50losSaldosSeQuedanEn500y50respectivamente(){
        //Arrange (set up)
        Cuenta cuentaTest = new Cuenta();
        Cuenta cuentaTestTrans = new Cuenta();
        cuentaTestTrans.ingresar(500);
        cuentaTest.ingresar(50);
        //Act
        cuentaTestTrans.hacerTrans(-100, cuentaTest);
        //Assert
        assertEquals(50,cuentaTest.getSaldo());
        assertEquals(500,cuentaTestTrans.getSaldo());
    }
    @Test
    void TransferenciaDe3000DesdeUnaCuentaCon3500aUnaCon50enlaPrimeraCuentaElSaldoSeQuedaraEn500yEnLaSegundaSeQuedaraEn3050(){
        //Arrange (set up)
        Cuenta cuentaTest = new Cuenta();
        Cuenta cuentaTestTrans = new Cuenta();
        cuentaTestTrans.ingresar(3500);
        cuentaTest.ingresar(50);
        //Act
        cuentaTestTrans.hacerTrans(3000, cuentaTest);
        //Assert
        assertEquals(3050,cuentaTest.getSaldo());
        assertEquals(500,cuentaTestTrans.getSaldo());
    }
    @Test
    void TransferenciaDe3000con01DesdeUnaCuentaCon3500aUnaCon50lasCuentasQuedaranComoEstaban(){
        //Arrange (set up)
        Cuenta cuentaTest = new Cuenta();
        Cuenta cuentaTestTrans = new Cuenta();
        cuentaTestTrans.ingresar(3500);
        cuentaTest.ingresar(50);
        //Act
        cuentaTestTrans.hacerTrans(3000.01, cuentaTest);
        //Assert
        assertEquals(50,cuentaTest.getSaldo());
        assertEquals(3500,cuentaTestTrans.getSaldo());
    }
}
