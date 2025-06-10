package ntp.service;

import ntp.repository.InvoiceRepository;

public class InvoiceService {
	InvoiceRepository invoiceRepository = new InvoiceRepository();

	public boolean addInvoice(long makh) throws Exception {
		return invoiceRepository.addInvoice(makh) > 0;
	}

	public long getMaInvoice() throws Exception {
		return invoiceRepository.getMaInvoice();
	}

	public boolean addInvoiceDetail(String masach, long soluongmua, long mahoadon) throws Exception {
		return invoiceRepository.addInvoiceDetail(masach, soluongmua, mahoadon) > 0;
	}
}
