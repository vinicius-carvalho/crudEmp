package model.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.db.connection.ConnectionFactory;
import model.pet.Animal;

public class LivrosDaoJDBC implements PetDao {
	private ConnectionFactory factory;

	public LivrosDaoJDBC() {
		factory = new ConnectionFactory();
	}

	public boolean add(Animal pet) {
            
		int added = 0;
		try {
			Connection con = factory.createConnection();
			if (con != null) {
				String sql = "insert into pet (nome, peso, datan, tipo)"
						+ " values (?, ?, ?, ?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, pet.getNome());
				st.setFloat(2, pet.getPeso());
				st.setString(3, pet.getData());
				st.setString(4, pet.getTipo());
				added = st.executeUpdate();
				st.close();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return added > 0;
	}
        
        
        

	public List<Animal> list() {
		List<Animal> list = new ArrayList<Animal>();
		Connection con = factory.createConnection();

		if (con != null) {
			try {
				String sql = "select * from pet order by nome";
				PreparedStatement st = con.prepareStatement(sql);

				ResultSet rs = st.executeQuery();

				while (rs.next()) {
					Animal pet = createPet(rs);
					list.add(pet);
				}
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	private Animal createPet(ResultSet rs) throws SQLException {
		Animal pet = new Animal();
		pet.setId(rs.getLong("id"));
		pet.setNome(rs.getString("nome"));
		pet.setPeso(rs.getFloat("peso"));
		pet.setData(rs.getString("datan"));
		pet.setTipo(rs.getString("tipo"));

		return pet;
	}

	public Animal find(long id) {
		Animal pet = null;
		try {
			Connection con = factory.createConnection();
			if (con != null) {
				String sql = "select * from pet where id=?";
				PreparedStatement st = con.prepareStatement(sql);
				st.setLong(1, id);
				ResultSet rs = st.executeQuery();
				if (rs.next()) {
					pet = createPet(rs);
				}
				rs.close();
				st.close();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pet;
	}

	public int remove(long id) {
		int removed = -1;
		try {
			Connection con = factory.createConnection();
			if (con != null) {
				String sql = "delete from pet where id=?";
				PreparedStatement st = con.prepareStatement(sql);
				st.setLong(1, id);
				removed = st.executeUpdate();
				st.close();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removed;
	}

	public int update(Animal pet) {
		int updated = -1;
		try {
			Connection con = factory.createConnection();
			if (con != null) {
				String sql = "update pet set nome=?, peso=?, datan=?, tipo=? where id=?";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, pet.getNome());
				st.setFloat(2, pet.getPeso());
				st.setString(3, pet.getData());
				st.setString(4, pet.getTipo());
				st.setLong(5, pet.getId());

				updated = st.executeUpdate();
				st.close();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updated;
	}

	public Animal findByLogin(String nome) {
		Animal pet = null;
		try {
			Connection con = factory.createConnection();

			if (con != null) {
				String sql = "select * from pet where login=?";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, nome);
				ResultSet rs = st.executeQuery();

				if (rs.next()) {
					pet = createPet(rs);
				}
				rs.close();
				st.close();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pet;
	}

	public List<Animal> search(String term) {
		List<Animal> list = new ArrayList<Animal>();
		Connection con = factory.createConnection();

		if (con != null) {
			try {
				String sql = "select * from pet where nome like ? order by nome";

				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, "%" + term + "%");

				ResultSet rs = st.executeQuery();

				while (rs.next()) {
					Animal pet = createPet(rs);
					list.add(pet);
				}
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

}
