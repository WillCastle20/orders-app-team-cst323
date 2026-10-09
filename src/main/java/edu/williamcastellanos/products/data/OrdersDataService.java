package edu.williamcastellanos.products.data;

import org.springframework.stereotype.Service;
import edu.williamcastellanos.products.models.OrdersModel;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import edu.williamcastellanos.products.data.OrderEntity;
import edu.williamcastellanos.products.mapper.OrderMapper;


@Service
public class OrdersDataService implements DataAccessInterface<OrdersModel> {

    // add a data member for the repository using dependency injection
@Autowired
private OrdersRepository ordersRepository;

private DataSource dataSource;
private JdbcTemplate jdbcTemplate;

// constructor for dependency injection
public OrdersDataService(DataSource dataSource) {
    this.dataSource = dataSource;
    this.jdbcTemplate = new JdbcTemplate(dataSource);
}

	@Override
public OrdersModel getById(int id) {
    OrderEntity orderEntity = ordersRepository.findById(id).orElse(null);

    if (orderEntity == null) {
        return null;
    }

    return OrderMapper.toModel(orderEntity);
}

@Override
public Iterable<OrdersModel> getAll() {
    ArrayList<OrdersModel> orderModels = new ArrayList<OrdersModel>();
    Iterable<OrderEntity> orderEntities = ordersRepository.findAll();

    for (OrderEntity orderEntity : orderEntities) {
        orderModels.add(OrderMapper.toModel(orderEntity));
    }

    return orderModels;
}

@Override
public OrdersModel create(OrdersModel item) {
    OrderEntity orderEntity =
        ordersRepository.save(OrderMapper.toEntity(item));

    return OrderMapper.toModel(orderEntity);
}

@Override
public OrdersModel update(OrdersModel item) {
    OrderEntity orderEntity =
        ordersRepository.save(OrderMapper.toEntity(item));

    return OrderMapper.toModel(orderEntity);
}

@Override
public boolean deleteById(int id) {
    ordersRepository.deleteById(id);
    return true;
}
}