﻿using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using PGK.Application.App.Group.Commands.CreateGroup;
using PGK.Application.App.Group.Commands.DeleteGroup;
using PGK.Application.App.Group.Commands.UpdateGroup;
using PGK.Application.App.Group.Queries.GetClassroomTeacher;
using PGK.Application.App.Group.Queries.GetGroupDetails;
using PGK.Application.App.Group.Queries.GetGroupList;
using PGK.Application.App.Group.Queries.GetGroupStudentList;
using PGK.Application.App.Raportichka.Commands.CreateRaportichka;
using PGK.Application.App.User.Teacher.Queries.GetTeacherUserDetails;
using PGK.WebApi.Models.Group;

namespace PGK.WebApi.Controllers
{
    public class GroupController : Controller
    {
        [Authorize]
        [HttpGet]
        public async Task<ActionResult<GroupListVm>> GetAll(
            string? search,
            int pageNumber = 1, int pageSize = 20
            )
        {
            var query = new GetGroupListQuery
            {
                Search = search,
                PageNumber = pageNumber,
                PageSize = pageNumber
            };

            var vm = await Mediator.Send(query);

            return Ok(vm);
        }

        [Authorize]
        [HttpGet("{id}")]
        public async Task<ActionResult<GroupDetails>> GetDetails(int id)
        {
            var query = new GetGroupDetailsQuery
            {
                GroupId = id
            };

            var details = await Mediator.Send(query);

            return Ok(details);
        }

        [Authorize]
        [HttpGet("{id}/ClassroomTeacher")]
        public async Task<ActionResult<TeacherUserDetails>> GetClassroomTeacher(int id)
        {
            var query = new GetClassroomTeacherQuery
            {
                GroupId = id
            };

            var details = await Mediator.Send(query);

            return Ok(details);
        }

        [Authorize]
        [HttpGet("{id}/Students")]
        public async Task<ActionResult<GroupStudentListVm>> GetStudentAll(
            int id, int pageNumber = 1, int pageSize = 20
            )
        {
            var query = new GetGroupStudentListQuery
            {
                GroupId = id,
                PageNumber = pageNumber,
                PageSize = pageSize
            };

            var vm = await Mediator.Send(query);

            return Ok(vm);
        }

        [Authorize(Roles = "TEACHER,ADMIN")]
        [HttpPost]
        public async Task<ActionResult<CreateGroupVm>> Create(CreateGroupCommand command)
        {
            var vm = await Mediator.Send(command);

            return Ok(vm);
        }

        [Authorize(Roles = "TEACHER,ADMIN")]
        [HttpPost("{id}/Raportichka")]
        public async Task<ActionResult<CreateRaportichkaVm>> CreateRaportichka(int id)
        {
            var command = new CreateRaportichkaCommand
            {
                Role = UserRole.Value,
                UserId = UserId,
                GroupId = id
            };

            var vm = await Mediator.Send(command);

            return Ok(vm);
        }

        [Authorize(Roles = "TEACHER,EDUCATIONAL_SECTOR")]
        [HttpPut("{id}")]
        public async Task<ActionResult<GroupDetails>> Update(
            int id, [FromBody] UpdateGroupModel model)
        {
            var command = new UpdateGroupCommand
            {
                Id = id,
                Number = model.Number,
                SpecialityId = model.SpecialityId,
                ClassroomTeacherId = model.ClassroomTeacherId,
                HeadmanId = model.HeadmanId,
                DeputyHeadmaId = model.DeputyHeadmaId,
                DepartmentId = model.DepartmentId
            };

            var dto = await Mediator.Send(command);

            return Ok(dto);
        }

        [Authorize(Roles = "TEACHER,EDUCATIONAL_SECTOR")]
        [HttpDelete("{id}")]
        public async Task<ActionResult> Delete(int id)
        {
            var command = new DeleteGroupCommand { GroupId = id };

            await Mediator.Send(command);

            return Ok();
        }
    }
}
