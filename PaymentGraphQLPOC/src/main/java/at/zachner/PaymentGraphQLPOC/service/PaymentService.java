package at.zachner.PaymentGraphQLPOC.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import at.zachner.PaymentGraphQLPOC.dao.entity.Payment;
import at.zachner.PaymentGraphQLPOC.dao.repository.PaymentRepository;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(final PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public Payment createPayment(final int amount,final String receiver) {
        final Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setReceiver(receiver);
        return this.paymentRepository.save(payment);
    }

    @Transactional(readOnly = true)
    public List<Payment> getAllPayments() {
        return this.paymentRepository.findAll().stream().limit(100).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Payment> getPayment(final long id) {
        return this.paymentRepository.findById(id);
    }
}