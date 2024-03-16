static void main(String[] args) {
  def customers = [
          [
                  "customer-id": 123,
                  name: "John Doe",
                  address: [
                          street: "123 Main St",
                          city: "Anytown",
                          state: "CA",
                          zip: "12345"
                  ],
                  orders: [
                          [
                                  "order-id": 1001,
                                  items: [
                                          ["product-id": "ABC123", quantity: 2],
                                          ["product-id": "DEF456", quantity: 1]
                                  ],
                                  total: 25.99
                          ],
                          [
                                  "order-id": 1002,
                                  items: [
                                          ["product-id": "GHI789", quantity: 1]
                                  ],
                                  total: 10.00
                          ]
                  ]
          ],
          [
                  "customer-id": 456,
                  name: "Jane Smith",
                  address: [
                          street: "456 Elm St",
                          city: "Anytown",
                          state: "NY",
                          zip: "54321"
                  ],
                  orders: []
          ]
  ]

  def transformedData = customers.collect { customer ->
    def customerId = customer['customer-id']
    def name = customer.name
    def zip = customer.address.zip
    def totalOrderValue = customer.orders.sum { order -> order.total }
    def numberOfProducts = customer.orders.sum { order ->
      order.items.sum { item -> item.quantity }
    }
    "$name, $customerId, $numberOfProducts, $totalOrderValue"
  }

  transformedData.each { println it }

}