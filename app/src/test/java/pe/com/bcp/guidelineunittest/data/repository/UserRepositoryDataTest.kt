package pe.com.bcp.guidelineunittest.data.repository

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import pe.com.bcp.guidelineunittest.commons.utils.Either
import pe.com.bcp.guidelineunittest.commons.utils.getOrElse
import pe.com.bcp.guidelineunittest.data.datasource.UserDataSource
import pe.com.bcp.guidelineunittest.exception.Failure
import pe.com.bcp.guidelineunittest.utils.FakeValuesModel

class UserRepositoryDataTest {
    @MockK(relaxed = true)
    private lateinit var dataSource: UserDataSource

    @InjectMockKs
    private lateinit var repository: UserRepositoryData

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun notNullViewModel() {
        Assert.assertNotNull(repository)
    }

    @Test
    fun `given valid params when run then verify result`() = runTest {
        //given
        val fakeResult = FakeValuesModel.users()
        coEvery { dataSource.users() } returns Either.Right(fakeResult)

        //when
        val result = repository.users()

        //then
        Assert.assertEquals(fakeResult.size, result.getOrElse(listOf()).size)
    }

    @Test
    fun `given invalid params when run then verify result`() = runTest {
        //given
        coEvery { dataSource.users() } returns Either.Left(Failure.NetworkConnection)

        //when
        val result = repository.users()

        //then
        Assert.assertTrue(result.isLeft)
    }
}