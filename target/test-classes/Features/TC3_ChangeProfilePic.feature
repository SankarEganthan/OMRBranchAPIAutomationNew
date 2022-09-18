Feature: Change Profile Pic Module API automation

Scenario Outline: Get User logtoken from login endpoint, add user address, update user address, delete user  address, get user address and Change Profile pic
    Given User add header
    And User add basic authentication for login
    When User send "POST" request for login endpoint
    Then User verify the status code is 200
    And User verify the login response body firstName present as "Sankar" and get the logtoken saved
    When User add header and basic authentication to add address
    And User should enter the address details "<first_name>", "<last_name>", "<mobile>", "<apartment>", <state>, <city>, <country>, "<zipcode>", "<address>" and "<address_type>"
    And User send "POST" request to add user address
    Then User verify the status code is 200
    And User verify the add address output message "Address added successfully"
    When User add header and basic authentication to update address
    And User should enter the update address details with address id
    And User send "PUT" request to update user address
    Then User verify the status code is 200
    And User verify the update address output message "Address updated successfully"
    When User add header and basic authentication for delete address
    And User should enter the address id details <address_id>
    And User send "DELETE" request to delete user address
    Then User verify the status code is 200
    And User verify the delete address output message "Address deleted successfully"
    When User add header and basic authentication for get address
    And User send "GET" request to get user address
    Then User verify the status code is 200
    And User verify the get address output message "OK"
    When User add header and basic authentication to change profile pic
    And User send "POST" request to change profile pic
    Then User verify the status code is 200
    And User verify the profile pic updated message "Profile updated Successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment   | state | city | country | zipcode | address          | address_type |
      | Sankar     | Eganthan  | 7299476012 | No 7 Greens |     6 |   24 |      13 |  600098 | Thirumullaivoyal | Home         |
