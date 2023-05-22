public class ManejadorCronometroEventListener implements CronometroEventListener{

    @Override
    public void StopCronometro(CronometroEventObject args) {
        // TODO Auto-generated method stub
        System.out.println("Parar el funcionamiento del contador");
        
        Cronometro cronoTemp=new Cronometro();
        cronoTemp=(Cronometro)args.getSource();
        cronoTemp.getTask().cancel();
      
       
    }

    @Override
    public void StartCronometro(CronometroEventObject args) {
        // TODO Auto-generated method stub
        System.out.println("Empieza el funcionamiento del contador");
        Cronometro cronoTemp=new Cronometro();
        cronoTemp=(Cronometro)args.getSource();
        cronoTemp.contar();
      
    }

    @Override
    public void ResetCronometro(CronometroEventObject args) {
        // TODO Auto-generated method stub
      
    }
    
}
