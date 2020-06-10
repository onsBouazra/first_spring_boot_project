
package com.example.demo.daos;
import com.example.demo.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository


public interface IClient extends JpaRepository<Client,Long>
{


}
