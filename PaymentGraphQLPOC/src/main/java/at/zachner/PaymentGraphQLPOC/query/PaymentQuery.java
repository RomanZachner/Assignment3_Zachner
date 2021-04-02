package at.zachner.PaymentGraphQLPOC.query;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import at.zachner.PaymentGraphQLPOC.dao.entity.Payment;
import at.zachner.PaymentGraphQLPOC.service.PaymentService;

@Component
public class PaymentQuery implements GraphQLQueryResolver {
    @Autowired
    private PaymentService paymentService;

    public List<Payment> getPayments() {
        return this.paymentService.getAllPayments();
    }

    public Optional<Payment> getPayment(final long id) {
        return this.paymentService.getPayment(id);
    }
}