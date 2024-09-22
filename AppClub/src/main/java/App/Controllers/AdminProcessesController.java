package App.Controllers;

/**
 * @author Arbaces Restrepo, Yhogan Viancha, Kevin Parra
 */

import App.Service.InvoiceService;
import App.Service.LoginService;
import App.Service.PartnerService;

public class AdminProcessesController implements ControllerInterface {
    private static final String MENU = "Ingrese la opcion que desea \n 1. Historial de facturación \n 2. Autorizar cambios a VIP \n 9. Volver a menú principal \n";
    
    private final PartnerService partnerService = new PartnerService();
    private final InvoiceService invoiceService = new InvoiceService();
    
    @Override
    public void session() throws Exception {
        boolean session = true;
        while (session) {
            session = menu();
        }
    }

    private boolean menu() {
        try {
            System.out.println("bienvenido " + LoginService.user.getUserName());
            System.out.print(MENU);
            String option = Utils.getReader().nextLine();
            return options(option);

        } catch ( Exception e ) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private boolean options(String option) throws Exception{
        switch (option) {
            case "1": {
                this.invoiceService.historyInvoice();
                return true;
            }
            case "2": {
                this.partnerService.changePartnersToVIP();
                return true;
            }
            case "9": {
                System.out.println("Se ha cerrado sesion");
                return false;
            }
            default: {
                System.out.println("ingrese una opcion valida");
                return true;
            }
        }
    }
}
